package com.nathan.learn.design.creation.factory;

/**
 * 抽象工厂模式创建的是对象家族，也就是很多对象而不是一个对象，并且这些对象是相关的，也就是说必须一起创建出来。
 * 而工厂方法模式只是用于创建一个对象，这和抽象工厂模式有很大不同。
 * <p>
 * 抽象工厂:
 * <pre>
 * public abstract BenzCar createBenzCar(String car) throws Exception;
 * public abstract BmwCar createBmwCar(String car) throws Exception;
 * public abstract AudiCar createAudiCar(String car) throws Exception;
 * </pre>
 * 工厂模式:
 * <pre>
 * public abstract Car2 createCar(String car) throws Exception;
 * </pre>
 */
public class AbstractFactory {

    public static void main(String[] args) throws Exception {
        Driver3 d = new BusinessDriver();
        AudiCar car = d.createAudiCar("");
        car.drive();
    }
}

//抽象产品（Bmw和Audi同理）
abstract class BenzCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//具体产品（Bmw和Audi同理
class BenzBusinessCar extends BenzCar {
    @Override
    public void drive() {
        System.out.println(this.getName() + "----BenzBusinessCar-----------------------");
    }
}

abstract class BmwCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BmwBusinessCar extends BmwCar {
    @Override
    public void drive() {
        System.out.println(this.getName() + "----BmwBusinessCar-----------------------");
    }
}

abstract class AudiCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AudiBusinessCar extends AudiCar {
    @Override
    public void drive() {
        System.out.println(this.getName() + "----AudiBusinessCar-----------------------");
    }
}


//抽象工厂
abstract class Driver3 {
    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;

    public abstract AudiCar createAudiCar(String car) throws Exception;
}

//具体工厂
class BusinessDriver extends Driver3 {
    @Override
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }

    @Override
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }

    @Override
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiBusinessCar();
    }
}
