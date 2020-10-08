package com.design.creation.prototype.deep;

import java.io.Serializable;

public class Company implements Cloneable, Serializable {
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Company clone(){
        Company company=null;
        try {
            company= (Company) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return company;
    }
}
