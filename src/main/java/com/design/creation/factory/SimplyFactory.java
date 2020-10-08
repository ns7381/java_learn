package com.design.creation.factory;

import java.io.IOException;

/**
 * 简单工厂(Simple Factory)，它把实例化的操作单独放到一个类中，这个类就成为简单工厂类，让简单工厂类来决定应该用哪个具体子类来实例化，这样做能把客户类和具体子类的实现解耦，客户类不再需要知道有哪些子类以及应当实例化哪个子类
 * <p>
 * 隐藏了对象创建的细节，将产品的实例化过程放到了工厂中实现。遵循了依赖倒转原则。<br/>
 * 每添加一个产品子类，都必须在工厂类中添加一个判断分支(或一个方法)，这违背了OCP(开放-封闭原则)。
 */
class SimplyFactory {

    public static Car createCar(String car) {
        Car c = null;
        if ("Benz".equalsIgnoreCase(car)) {
            c = new Benz();
        } else if ("Bmw".equalsIgnoreCase(car)) {
            c = new Bmw();
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        Car car = SimplyFactory.createCar("benz");
        car.setName("benz");
        car.drive();
    }
}

abstract class Car {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Benz extends Car {
    @Override
    public void drive() {
        System.out.println(this.getName() + "----go-----------------------");
    }
}

class Bmw extends Car {
    @Override
    public void drive() {
        System.out.println(this.getName() + "----go-----------------------");
    }
}