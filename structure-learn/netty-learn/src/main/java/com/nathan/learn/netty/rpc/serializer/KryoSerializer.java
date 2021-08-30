package com.nathan.learn.netty.rpc.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class KryoSerializer implements Serializer {

    private static final ThreadLocal<Kryo> KRYO_LOCAL = new ThreadLocal<Kryo>() {
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);// 支持循环引用
            kryo.setRegistrationRequired(false);// 关闭注册行为
            return kryo;
        }
    };

    @Override
    public <T> ByteBuffer serialize(T t) {
        Kryo kryo = KRYO_LOCAL.get();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output, t);
        output.close();
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override
    public <T> T deserialize(ByteBuffer bytes) {
        Kryo kryo = KRYO_LOCAL.get();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes.array());
        Input input = new Input(byteArrayInputStream);
        input.close();
        return (T) kryo.readClassAndObject(input);
    }

}
