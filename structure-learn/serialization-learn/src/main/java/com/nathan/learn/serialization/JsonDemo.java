package com.nathan.learn.serialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JsonDemo {
    private static User user;

    public static void main(String[] args) throws IOException {
        user = new JsonDemo.User();
        user.setName("nathan");
        user.setAge(3);
        user.setSalary(new BigDecimal("123456789.0123"));
        user.setDate(new Date());
        user.setDate2(new java.sql.Date(System.currentTimeMillis()));

//        fastjsonTest();
//        gsonTest();
        jacksonTest();
    }

    private static void jacksonTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // 1. string <-> object
        String userStr = mapper.writeValueAsString(user);
        System.out.println(userStr);
        User user = mapper.readValue(userStr, User.class);
        System.out.println(user);

        mapper.writeValue(new File("test.txt"), JsonDemo.user);
    }

    private static void gsonTest() {
        //1. 基本数据类型的解析
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        //基本数据类型的生成
        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"
        //2. string <-> object
        String jsonObject = gson.toJson(user);
        System.out.println(jsonObject);
        jsonString = "{\"name\":\"kidou\",\"age\":24}";
        User user = gson.fromJson(jsonString, User.class);
        System.out.println(user);
        //3. generic
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        System.out.println(Arrays.toString(strings));

        //不再重复定义Result类
        Type userType = new TypeToken<Result<User>>() {
        }.getType();
        Result<User> userResult = gson.fromJson("{\"code\":\"0\",\"message\":\"success\",\"data\":{\"name\":\"kidou\",\"age\":24}}", userType);
        System.out.println("result: " + userResult.data);
        ;

        Type userListType = new TypeToken<Result<List<User>>>() {
        }.getType();
        Result<List<User>> userListResult = gson.fromJson("{\"code\":\"0\",\"message\":\"success\",\"data\":[]}", userListType);
        List<User> users = userListResult.data;
        System.out.println("size: " + users.size());
    }

    private static void fastjsonTest() throws IOException {
        //1. string <-> object
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
        // 输出 {"age":3,"name":"nathan","old":false,"salary":123456789.0123}

        jsonString = "{\"age\":3,\"birthdate\":1496738822842,\"name\":\"校长\",\"old\":true,\"salary\":123456789.0123}";
        User u = JSON.parseObject(jsonString, User.class);
        System.out.println(u.getName());
        String jsonStringArray = "[{\"age\":3,\"birthdate\":1496738822842,\"name\":\"校长\",\"old\":true,\"salary\":123456789.0123}]";
        List<User> userList = JSON.parseArray(jsonStringArray, User.class);
        System.out.println(userList.size());
        // // 输出 nathan 输出 1


        //2. file <-> object
        JSONWriter jsonWriter = new JSONWriter(new FileWriter("test.txt"));
        jsonWriter.writeObject(u);
        jsonWriter.close();
        JSONReader jsonReader = new JSONReader(new FileReader("test.txt"));
        User user1 = jsonReader.readObject(User.class);
        jsonReader.close();
        System.out.println(user1);

    }

    static class Result<T> {
        public int code;
        public String message;
        public T data;
    }

    static class User {
        @JSONField(format = "MM dd, yyyy h:mm:ss aa")
        private java.util.Date date;
        @JSONField(format = "MM-dd-yyyy h:mm:ss aa")
        @SerializedName("create_date")//gson
        public java.sql.Date date2;

        String name;
        int age;
        BigDecimal salary;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public java.sql.Date getDate2() {
            return date2;
        }

        public void setDate2(java.sql.Date date2) {
            this.date2 = date2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "User{" +
                    "date=" + date +
                    ", date2=" + date2 +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
