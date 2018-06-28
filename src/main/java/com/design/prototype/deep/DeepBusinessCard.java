package com.design.prototype.deep;

public class DeepBusinessCard implements Cloneable {
    private String name;
    private Company company = new Company();

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String name, String address) {
        this.company.setName(name);
        this.company.setAddress(address);
    }

    @Override
    public DeepBusinessCard clone() {
        DeepBusinessCard businessCard = null;
        try {
            businessCard = (DeepBusinessCard) super.clone();
            businessCard.company = this.company.clone();//1

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return businessCard;
    }

    public void show() {
        System.out.println("name:" + name);
        System.out.println("company:" + company.getName() + "-address-" + company.getAddress());
    }

}
