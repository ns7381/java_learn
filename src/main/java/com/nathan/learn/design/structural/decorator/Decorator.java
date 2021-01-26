package com.nathan.learn.design.structural.decorator;

public class Decorator implements Component{
    private Component component;
    public Decorator(Component component) {
        this.component = component;
    }
    @Override
    public void doSomething() {
        component.doSomething();
    }
}
