package com.nathan.learn.cache.custom;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MappingStoreSerializerJsonImpl extends MappingStoreSerializer {
    private static final Logger LOG = LoggerFactory.getLogger(MappingStoreSerializerJsonImpl.class);

    @Override
    public <T> String serialize(Map<String, T> records) {
        return JSON.toJSONString(records);
    }

    @Override
    public <T> Map<String, T> deserialize(String data) {
        return JSON.parseObject(data, Map.class);
    }
}
