/*
 * Ant Group
 * Copyright (c) 2004-2021 All Rights Reserved.
 */
package com.nathan.learn.netty.rpc;

import lombok.AllArgsConstructor;

/**
 * @author ningsheng
 * @version RpcEndpointAddress.java, v 0.1 2021年10月29日 2:34 下午 ningsheng
 */
@AllArgsConstructor
public class RpcEndpointAddress {
    RpcAddress rpcAddress;
    String name;
}