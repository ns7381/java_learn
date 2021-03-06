package com.nathan.learn.design.creation.prototype.deep;

public class Main {
    public static void main(String[] args) {
        DeepBusinessCard businessCard=new DeepBusinessCard();
        businessCard.setName("钱三");
        businessCard.setCompany("阿里","北京望京");

        DeepBusinessCard cloneCard1=businessCard.clone();
        cloneCard1.setName("赵四");
        cloneCard1.setCompany("百度","北京西二旗");

        DeepBusinessCard cloneCard2=businessCard.clone();
        cloneCard2.setName("孙五");
        cloneCard2.setCompany("腾讯","北京中关村");

        businessCard.show();
        cloneCard1.show();
        cloneCard2.show();
        System.out.println(businessCard);
        System.out.println(cloneCard1);
        System.out.println(cloneCard2);
    }
}
