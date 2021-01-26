package com.nathan.learn.design.creation.singleton;

/**
 * 当 Singleton 类加载时，静态内部类 InstanceHolder 没有被加载进内存。
 * 只有当调用 getInstance() 方法从而触发 InstanceHolder.INSTANCE 时 InstanceHolder 才会被加载，此时初始化 INSTANCE 实例。
 * 这种方式不仅具有延迟初始化的好处，而且由虚拟机提供了对线程安全的支持。
 *
 * @author nathan
 */
public class StaticInnerClassSingleton {
    private static class InstanceHolder {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
