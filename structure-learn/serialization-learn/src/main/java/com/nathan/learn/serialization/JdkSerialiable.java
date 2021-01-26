package com.nathan.learn.serialization;

import java.io.*;
import java.util.Arrays;

public class JdkSerialiable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        SomeClass object = new SomeClass();
        object.value = "Hello jdk!";
        os.writeObject(object);
        os.close();
        System.out.println(Arrays.toString(baos.toByteArray()));
        File file = new File("object.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(baos.toByteArray());
        fos.close();

        ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        SomeClass object2 = (SomeClass) is.readObject();
        is.close();
        System.out.println(object2.value);
    }

    static class SomeClass implements Serializable {
        String value;
    }
}
