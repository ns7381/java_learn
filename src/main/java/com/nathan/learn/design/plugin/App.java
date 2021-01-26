package com.nathan.learn.design.plugin;

import com.nathan.learn.design.plugin.example.IHelloService;

public class App {
    public static void main(String[] args) {

        PluginManager pluginManager = PluginManager.getMgr();
        pluginManager.addExternalJar("/Users/ningsheng/project/java/java_learn/src/main/java/com/design/plugin/example");

        IHelloService helloService = pluginManager.getPlugin("com.design.plugin.example.HelloServiceImpl", IHelloService.class);
        helloService.hello("ricky");
    }

}
