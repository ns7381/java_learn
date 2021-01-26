package com.nathan.learn.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class KryoSerializer {

    private static final ThreadLocal<Kryo> KRYO_LOCAL = new ThreadLocal<Kryo>() {
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);// 支持循环引用
            kryo.setRegistrationRequired(false);// 关闭注册行为
            return kryo;
        }
    };

    public byte[] serialize(Object obj) {
        Kryo kryo = KRYO_LOCAL.get();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output, obj);
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    public <T> T deserialize(byte[] bytes) {
        Kryo kryo = KRYO_LOCAL.get();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input = new Input(byteArrayInputStream);
        input.close();
        return (T) kryo.readClassAndObject(input);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KryoSerializer().serialize("sss")));
    }


}