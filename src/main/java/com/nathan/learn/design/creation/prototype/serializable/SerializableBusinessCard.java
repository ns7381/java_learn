package com.nathan.learn.design.creation.prototype.serializable;

import com.nathan.learn.design.creation.prototype.deep.Company;

import java.io.*;

public class SerializableBusinessCard implements Serializable {
    private String name;
    private Company company = new Company();

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String name, String address) {
        this.company.setName(name);
        this.company.setAddress(address);
    }

    public void show() {
        System.out.println("name:" + name);
        System.out.println("company:" + company.getName() + "-address-" + company.getAddress());
    }

    public SerializableBusinessCard deepClone() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return (SerializableBusinessCard) oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
