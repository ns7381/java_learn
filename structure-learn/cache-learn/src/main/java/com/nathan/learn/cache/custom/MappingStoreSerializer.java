package com.nathan.learn.cache.custom;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ReflectionUtils;

import java.util.Map;

public abstract class MappingStoreSerializer {
    private static final String HIVE_KEY_MAPPING_STORE_SERIALIZER = "hive.jd.mapping.store.serializer";

    private static MappingStoreSerializer defaultSerializer;

    public static MappingStoreSerializer getSerializer(Configuration conf) {
        if (defaultSerializer == null) {
            synchronized (MappingStoreSerializer.class) {
                if (defaultSerializer == null) {
                    defaultSerializer = newSerializer(conf);
                }
            }
        }
        return defaultSerializer;
    }

    private static MappingStoreSerializer newSerializer(final Configuration conf) {
        Class<? extends MappingStoreSerializer> serializerName = conf.getClass(
                HIVE_KEY_MAPPING_STORE_SERIALIZER,
                MappingStoreSerializerJsonImpl.class,
                MappingStoreSerializer.class);
        return ReflectionUtils.newInstance(serializerName, conf);
    }

    public abstract <T> String serialize(Map<String, T> records);

    public abstract <T> Map<String, T> deserialize(String data);
}
