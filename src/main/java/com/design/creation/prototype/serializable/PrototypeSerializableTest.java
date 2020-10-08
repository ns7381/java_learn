package com.design.creation.prototype.serializable;

public class PrototypeSerializableTest {
    public static void main(String[] args) {
        SerializableBusinessCard businessCard = new SerializableBusinessCard();
        businessCard.setName("钱三");
        businessCard.setCompany("阿里","北京望京");
        SerializableBusinessCard cloneCard1=businessCard.deepClone();
        cloneCard1.setName("赵四");
        cloneCard1.setCompany("百度","北京西二旗");

        SerializableBusinessCard cloneCard2=businessCard.deepClone();
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
