/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc.network.client;

import com.google.common.base.Preconditions;
import com.nathan.learn.netty.rpc.network.TransportContext;

/**
 * @author ningsheng
 * @version TransportClientFactory.java, v 0.1 2021年10月29日 8:07 下午 ningsheng
 */
public class TransportClientFactory {
    private final TransportContext context;

    public TransportClientFactory(TransportContext context) {
        this.context = Preconditions.checkNotNull(context);

    }
}