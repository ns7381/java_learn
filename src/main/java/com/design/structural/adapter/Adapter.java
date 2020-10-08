package com.design.structural.adapter;

/**
 *  对象适配器, 使用组合
 * @author nathan
 */
public class Adapter implements Target{
    /**
     * 持有需要被适配的接口对象
     */
    private final Adaptee adaptee;
    /**
     * 构造方法，传入需要被适配的对象
     * @param adaptee 需要被适配的对象
     */
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        // TODO Auto-generated method stub
        adaptee.specificRequest();
    }

}
