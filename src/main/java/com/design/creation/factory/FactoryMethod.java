package com.design.creation.factory;


/**
 * 工厂方法(Factory Method)，它定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类
 * <p>
 * 由于简单工厂方法模式不满足OCP, 因此就出现了工厂方法模式; <br/>
 * 在工厂方法模式中，工厂父类负责定义创建产品对象的公共接口，而工厂子类则负责生成具体的产品对象
 *
 * @author nathan
 */
public class FactoryMethod {
    public static void main(String[] args) throws Exception {
        Driver2 d = new BenzDriver2();
        Car2 c = d.createCar();
        c.drive();
    }
}

abstract class Car2 {
    String name;

    public abstract void drive();

}

class Benz2 extends Car2 {
    String name = "benz";

    @Override
    public void drive() {
        System.out.println(this.name + "----go-----------------------");
    }
}

class Bmw2 extends Car2 {
    String name = "bmw";

    @Override
    public void drive() {
        System.out.println(this.name + "----go-----------------------");
    }
}


abstract class Driver2 {
    public abstract Car2 createCar() throws Exception;
}

class BenzDriver2 extends Driver2 {
    @Override
    public Car2 createCar() throws Exception {
        return new Benz2();
    }
}

class BmwDriver2 extends Driver2 {
    @Override
    public Car2 createCar() throws Exception {
        return new Bmw2();
    }
}
