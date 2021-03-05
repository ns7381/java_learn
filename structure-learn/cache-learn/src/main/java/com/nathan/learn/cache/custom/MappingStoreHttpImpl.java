package com.nathan.learn.cache.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MappingStoreHttpImpl extends MappingStoreFileImpl {
    private static final Logger LOG = LoggerFactory.getLogger(MappingStoreHttpImpl.class);
    private String url;

    @Override
    public boolean initDriver() {
        super.initDriver();
        if (this.url == null) {
            url = conf.get("hive.jd." + getIdentifier() + ".mapping.url");
        }
        setInitialized(true);
        return true;
    }

    @Override
    public <T> Map<String, T> getAll(Class<T> clazz) {
        Map<String, T> rst = null;
        try {
//            String data = HttpUtil.doGet(url);
//            return deserialize(data);
            return null;
        } catch (Exception e) {
            LOG.error("Cannot open read data from url " + url, e);
            return super.getAll(clazz);
        }
    }

    @Override
    public <T> boolean putAll(Map<String, T> records) {
        return super.putAll(records);
    }

    @Override
    public String getType() {
        return "http";
    }
}
