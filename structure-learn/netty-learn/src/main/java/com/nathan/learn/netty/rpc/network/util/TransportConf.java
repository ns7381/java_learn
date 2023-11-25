package com.nathan.learn.netty.rpc.network.util;

public class TransportConf {
    private final String module;

    public TransportConf(String module) {
        this.module = module;
    }


    public String ioMode() {
        return "NIO";
    }

    public String getModuleName() {
        return module;
    }

    /** Number of threads used in the server thread pool. Default to 0, which is 2x#cores. */
    public int serverThreads() {
        return 0;
    }
}
