package com.nathan.learn.spring.utils;

import com.nathan.learn.spring.config.ApplicationContextHolder;
import com.nathan.learn.spring.config.EnvironmentConfig;
import com.nathan.learn.spring.entity.JobEntityState;
import com.nathan.learn.spring.exception.SyncJobRuntimeException;
import org.apache.hadoop.yarn.api.records.FinalApplicationStatus;
import org.apache.hadoop.yarn.api.records.YarnApplicationState;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.HttpClientErrorException;

import static com.nathan.learn.spring.entity.JobEntityState.NOT_FOUND;
import static com.nathan.learn.spring.exception.ErrorType.JSON_TRANSFORM_ERROR;
import static com.nathan.learn.spring.exception.ErrorType.YARN_NOT_ACTIVE;

public class YarnUtils {
    private static final Logger logger = LoggerFactory.getLogger(YarnUtils.class);
    private static final String HTTP_CLUSTER_INFO = "/ws/v1/cluster/info";
    private static final String HTTP_APP_INFO = "/ws/v1/cluster/apps/";

    public static JobEntityState getJobStateFromYarn(String applicationId) {
        JSONObject response;
        String state, finalStatus;
        try {
            response = HttpUtils.getWithRetry(getActiveYarnAddress() + HTTP_APP_INFO + applicationId);
            JSONObject app = response.getJSONObject("app");
            state = app.getString("state");
            finalStatus = app.getString("finalStatus");
            return JobEntityState.fromApplicationState(YarnApplicationState.valueOf(state),
                    FinalApplicationStatus.valueOf(finalStatus));
        } catch (HttpClientErrorException.NotFound ex) {
            logger.error("Yarn application {} not found.", applicationId);
            return NOT_FOUND;
        } catch (JSONException e) {
            logger.error("Parse http request response error.", e);
            throw new SyncJobRuntimeException(JSON_TRANSFORM_ERROR);
        }
    }

    private static String getActiveYarnAddress() {
        EnvironmentConfig envConfig = ApplicationContextHolder.getBean(EnvironmentConfig.class);
        if (checkYarnAddressActive(envConfig.getYarnAddress())) {
            return envConfig.getYarnAddress();
        }
        if (checkYarnAddressActive(envConfig.getYarnBackupAddress())) {
            return envConfig.getYarnBackupAddress();
        }
        throw new SyncJobRuntimeException(YARN_NOT_ACTIVE);
    }

    private static Boolean checkYarnAddressActive(String yarnAddress) {
        JSONObject response;
        try {
            response = HttpUtils.getWithRetry(yarnAddress + HTTP_CLUSTER_INFO);
            JSONObject app = response.getJSONObject("clusterInfo");
            String haState = app.getString("haState");
            return "ACTIVE".equals(haState);
        } catch (JSONException e) {
            logger.error("Parse http request response error.", e);
            throw new SyncJobRuntimeException(JSON_TRANSFORM_ERROR);
        }
    }
}
