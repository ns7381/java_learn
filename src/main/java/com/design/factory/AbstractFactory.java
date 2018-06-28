package com.design.factory;
//抽象产品（Bmw和Audi同理）
abstract class BenzCar{
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
class BenzBusinessCar extends BenzCar{
    public void drive(){
        System.out.println(this.getName()+"----BenzBusinessCar-----------------------");
    }
}

abstract class BmwCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class BmwBusinessCar extends BmwCar{
    public void drive(){
        System.out.println(this.getName()+"----BmwBusinessCar-----------------------");
    }
}

abstract class AudiCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class AudiBusinessCar extends AudiCar{
    public void drive(){
        System.out.println(this.getName()+"----AudiBusinessCar-----------------------");
    }
}


//抽象工厂
abstract class Driver3{
    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;

    public abstract AudiCar createAudiCar(String car) throws Exception;
}
//具体工厂
class BusinessDriver extends Driver3{
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiBusinessCar();
    }
}

public class AbstractFactory {

    public static void main(String[] args) throws Exception {
        Driver3 d = new BusinessDriver();
        AudiCar car = d.createAudiCar("");
        car.drive();
    }
}
