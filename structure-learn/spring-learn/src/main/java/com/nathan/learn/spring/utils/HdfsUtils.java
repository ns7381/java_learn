package com.nathan.learn.spring.utils;

import com.nathan.learn.spring.config.ApplicationContextHolder;
import com.nathan.learn.spring.config.EnvironmentConfig;
import com.nathan.learn.spring.config.JobConfig;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import lombok.Data;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.tools.DistCp;
import org.apache.hadoop.tools.DistCpOptions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.nathan.learn.spring.exception.ErrorType.*;

public class HdfsUtils {
    private static final Logger logger = LoggerFactory.getLogger(HdfsUtils.class);
    private static final String REGEX_HDFS_PATH = "^(hdfs://)(ns\\d+)(.*)$";
    private static final String HADOOP_CONF_DIR = System.getenv("HADOOP_CONF_DIR");
    private static final Configuration HADOOP_CONF = new Configuration();

    static {
        if (!new File(HADOOP_CONF_DIR).exists()) {
            throw new SyncJobRuntimeException("HADOOP_CONF_DIR not exist.");
        }
        HADOOP_CONF.addResource(new Path(HADOOP_CONF_DIR, "core-site.xml"));
        HADOOP_CONF.addResource(new Path(HADOOP_CONF_DIR, "hdfs-site.xml"));
        HADOOP_CONF.addResource(new Path(HADOOP_CONF_DIR, "yarn-site.xml"));
        HADOOP_CONF.addResource(new Path(HADOOP_CONF_DIR, "mapred-site.xml"));
        HADOOP_CONF.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
    }

    public static Job runDistCp(Path src, Path dst) throws IOException {
        JobConfig jobConfig = ApplicationContextHolder.getBean(JobConfig.class);
        DistCpOptions options = new DistCpOptions(Collections.singletonList(src), dst);
        options.setSyncFolder(true);
        options.setDeleteMissing(true);
        options.setSkipCRC(true);
        options.setMaxMaps(jobConfig.getMaxMaps());
        options.setMapBandwidth(jobConfig.getMapBandwidth());
        options.setBlocking(false);
        options.preserve(DistCpOptions.FileAttribute.USER);
        options.preserve(DistCpOptions.FileAttribute.GROUP);
        options.preserve(DistCpOptions.FileAttribute.PERMISSION);
        options.preserve(DistCpOptions.FileAttribute.BLOCKSIZE);
        Job job;
        try {
            HADOOP_CONF.set("mapred.job.queue.name", jobConfig.getQueue());
            DistCp distcp = new DistCp(HADOOP_CONF, options);
            job = distcp.execute();
            return job;
        } catch (Exception e) {
            throw new IOException("Distcp execute error. ", e);
        }
    }

    public static Boolean exist(String path) {
        try {
            Path checkPath = new Path(path);
            return checkPath.getFileSystem(HADOOP_CONF).exists(checkPath);
        } catch (IOException e) {
            logger.error("Path {} not exist.", path);
            return false;
        }
    }

    public static String parseHdfsPath(String path, String cluster) {
        Pattern pattern = Pattern.compile(REGEX_HDFS_PATH);
        Matcher matcher = pattern.matcher(path);
        String nsName;
        if (matcher.find()) {
            nsName = matcher.group(2);
        } else {
            throw new SyncJobRuntimeException(HDFS_PATH_NOT_LEGAL_ERROR);
        }

        EnvironmentConfig envConfig = ApplicationContextHolder.getBean(EnvironmentConfig.class);

        String bdpopsAddress = String.format(envConfig.getBdpopsAddress(), cluster);
        Response response = HttpUtils.getWithRetry(bdpopsAddress, Response.class);
        NS foundNs = response.getData().stream()
                .filter(ns -> ns.getNsName().equals(nsName))
                .findAny().orElseThrow(() -> new SyncJobRuntimeException(HDFS_PATH_NN_NOT_FOUND_ERROR));

        String activeNNIp = null;
        for (NN nn : foundNs.getNnList()) {
            if (isActiveNN(String.format(envConfig.getHdfsAddress(), nn.getIp()))) {
                activeNNIp = nn.getIp();
                break;
            }
        }
        if (activeNNIp == null) {
            throw new SyncJobRuntimeException(HDFS_PATH_NOT_ACTIVE_ERROR);
        }
        return path.replaceFirst("(hdfs://ns\\d+)", String.format("hdfs://%s:8020", activeNNIp));
    }

    private static Boolean isActiveNN(String nnIpInfoAddr) {
        JSONObject resp = HttpUtils.getWithRetry(nnIpInfoAddr);
        JSONArray beans;
        String haState;
        try {
            beans = resp.getJSONArray("beans");
            JSONObject bean = beans.getJSONObject(0);
            haState = bean.getString("tag.HAState");
        } catch (JSONException e) {
            throw new SyncJobRuntimeException(JSON_TRANSFORM_ERROR);
        }
        return "active".equals(haState);
    }

    @Data
    public static class Response {
        List<NS> data;
        boolean success;
    }

    /**
     * {
     * "nnList": [ { "nnName": "nn44019", "ip": "172.21.139.132", "id": 3129 } ],
     * "nsName": "ns22010"
     * }
     */
    @Data
    public static class NS {
        List<NN> nnList;
        String nsName;
    }

    @Data
    public static class NN {
        String nnName;
        String ip;
        String id;
    }
}
