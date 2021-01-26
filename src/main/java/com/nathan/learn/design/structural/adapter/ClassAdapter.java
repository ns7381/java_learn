package com.nathan.learn.design.structural.adapter;

/**
 *  类适配器, 使用继承
 * @author nathan
 */
public class ClassAdapter extends  Adaptee implements Target{
    @Override
    public void request() {
        // TODO Auto-generated method stub
        super.specificRequest();
    }

}
