package com.nathan.learn.design.creation.singleton;

/**
 * 这是单例模式的最佳实践，它实现简单，并且在面对复杂的序列化或者反射攻击的时候，能够防止实例化多次。
 * @author nathan
 */

public enum EnumSingleton implements MySingleton {
    /**
     * singleton
     */
    INSTANCE {
        @Override
        public void doSomething() {
            System.out.println("complete singleton");
        }
    };

    public static MySingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}
