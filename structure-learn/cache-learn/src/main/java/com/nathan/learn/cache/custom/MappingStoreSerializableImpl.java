package com.nathan.learn.cache.custom;

import org.apache.hadoop.conf.Configuration;

import java.util.Map;

public abstract class MappingStoreSerializableImpl extends MappingStoreDriver {
    /**
     * Default serializer for this driver.
     */
    protected MappingStoreSerializer serializer;

    @Override
    public boolean init(Configuration config, String identifier) {
        boolean ret = super.init(config, identifier);
        this.serializer = MappingStoreSerializer.getSerializer(conf);
        return ret;
    }

    public <T> Map<String, T> deserialize(String data) {
        return this.serializer.deserialize(data);
    }

    public <T> String serialize(Map<String, T> records) {
        return this.serializer.serialize(records);
    }
}
