package com.design.singleton;

import com.design.Solution;

public enum EnumSingleton implements MySingleton {
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
