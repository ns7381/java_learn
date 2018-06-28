package com.design.factory;
//抽象产品
abstract class Car2{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
//具体产品
class Benz2 extends Car2{
    public void drive(){
        System.out.println(this.getName()+"----go-----------------------");
    }
}
class Bmw2 extends Car2{
    public void drive(){
        System.out.println(this.getName()+"----go-----------------------");
    }
}


//抽象工厂
abstract class Driver2{
    public abstract Car2 createCar(String car) throws Exception;
}
//具体工厂（每个具体工厂负责一个具体产品）
class BenzDriver2 extends Driver2{
    public Car2 createCar(String car) throws Exception {
        return new Benz2();
    }
}
class BmwDriver2 extends Driver2{
    public Car2 createCar(String car) throws Exception {
        return new Bmw2();
    }
}

public class FactoryMethon{
    public static void main(String[] args) throws Exception {
        Driver2 d = new BenzDriver2();
        Car2 c = d.createCar("benz");
        c.setName("benz");
        c.drive();
    }
}
