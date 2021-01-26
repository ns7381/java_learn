package com.nathan.learn.concurrent.jdk;

public class L0_Volatile_Order {

    public static volatile L0_Volatile_Order singleton;
    /**
     * 构造函数私有，禁止外部实例化
     */
    private L0_Volatile_Order() {};
    public static L0_Volatile_Order getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new L0_Volatile_Order();
                }
            }
        }
        return singleton;
    }
}
