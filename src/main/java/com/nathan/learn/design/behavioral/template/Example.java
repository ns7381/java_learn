package com.nathan.learn.design.behavioral.template;


import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板方法（Template Method）模式的定义如下：
 * 定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。。
 *
 * @author nathan
 */
public class Example {
    public static void main(String[] args) {
        AbstractSetting setting1 = new LocalSetting();
        System.out.println("test = " + setting1.getSetting("test"));
        System.out.println("test = " + setting1.getSetting("test"));
        AbstractSetting setting2 = new RedisSetting();
        System.out.println("autosave = " + setting2.getSetting("autosave"));
        System.out.println("autosave = " + setting2.getSetting("autosave"));
    }

}

abstract class AbstractSetting {
    public final String getSetting(String key) {
        String value = lookupCache(key);
        if (value == null) {
            value = lookupCache(key);
            putIntoCache(key, value);
        }
        return value;
    }

    protected abstract String lookupCache(String key);

    protected abstract void putIntoCache(String key, String value);
}

class LocalSetting extends AbstractSetting {
    private Map<String, String> cache = new HashMap<>();

    @Override
    protected String lookupCache(String key) {
        return cache.get(key);
    }

    @Override
    protected void putIntoCache(String key, String value) {
        cache.put(key, value);
    }
}

class RedisSetting extends AbstractSetting {
    private RedisClient client = RedisClient.create("redis://localhost:6379");

    @Override
    protected String lookupCache(String key) {
        try (StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            return commands.get(key);
        }
    }

    @Override
    protected void putIntoCache(String key, String value) {
        try (StatefulRedisConnection<String, String> connection = client.connect()) {
            RedisCommands<String, String> commands = connection.sync();
            commands.set(key, value);
        }
    }
}

