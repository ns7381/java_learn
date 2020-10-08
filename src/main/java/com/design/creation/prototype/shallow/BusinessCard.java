package com.design.creation.prototype.shallow;

public class BusinessCard implements Cloneable {
    private String name;
    private String company;
    public BusinessCard(){
        System.out.println("执行构造函数BusinessCard");
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    @Override
    public BusinessCard clone() {
        BusinessCard businessCard = null;
        try {
            businessCard = (BusinessCard) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return businessCard;
    }
    public void show() {
        System.out.println("name:" + name);
        System.out.println("company:" + company);
    }
}
