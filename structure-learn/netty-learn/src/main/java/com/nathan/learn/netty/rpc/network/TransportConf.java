package com.nathan.learn.netty.rpc.network;

import com.nathan.learn.netty.rpc.util.ConfigProvider;

public class TransportConf {
    private final ConfigProvider conf;

    private final String module;


    public TransportConf(String module, ConfigProvider conf) {
        this.module = module;
        this.conf = conf;
    }


    public int getInt(String name, int defaultValue) {
        return conf.getInt(name, defaultValue);
    }

    public String get(String name, String defaultValue) {
        return conf.get(name, defaultValue);
    }

    private String getConfKey(String suffix) {
        return "spark." + module + "." + suffix;
    }

    public String getModuleName() {
        return module;
    }

}
