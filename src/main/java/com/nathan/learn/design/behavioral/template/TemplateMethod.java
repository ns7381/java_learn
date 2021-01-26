package com.nathan.learn.design.behavioral.template;

/**
 * 模板方法（Template Method）模式的定义如下：
 * 定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。。
 *
 * @author nathan
 */
public class TemplateMethod {
    abstract static class AbstractPutAnyAnimal {
        public void putRefrigerator() {
            openDoor();
            putAnyAnimal();
            closeDoor();
            //默认为false,重新这个方法决定是否执行addTemperature();方法
            if (isAdd()) {
                addTemperature();
            }
        }

        public void openDoor() {
            System.out.println("open the door");
        }

        public void closeDoor() {
            System.out.println("close the door");
        }

        abstract void putAnyAnimal();

        void addTemperature() {
            System.out.println("plus one");
        }

        ;

        //定义一个空实现，由子类决定是否对其进行实现
        boolean isAdd() {
            return false;
        }
    }

    class Elephant extends AbstractPutAnyAnimal {
        @Override
        void putAnyAnimal() {
            System.out.println("put in the Elephant");
        }

        //子类实现钩子方法
        @Override
        boolean isAdd() {
            return true;
        }
    }

    class Tiger extends AbstractPutAnyAnimal {
        //子类实现自己的业务逻辑
        @Override
        void putAnyAnimal() {
            System.out.println("put in the Tiger");
        }
    }
}
