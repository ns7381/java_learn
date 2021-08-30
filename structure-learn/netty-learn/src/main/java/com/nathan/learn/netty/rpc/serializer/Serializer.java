package com.nathan.learn.netty.rpc.serializer;

import java.nio.ByteBuffer;

public interface Serializer {
    <T> ByteBuffer serialize(T t);

    <T> T deserialize(ByteBuffer bytes);
}
