package com.nathan.learn.design.plugin;


import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class PluginManager {
    private volatile static PluginManager mgr;
    private PluginClassLoader pluginClassLoader;
    private volatile boolean init;

    private PluginManager(){

    }

    public static PluginManager getMgr(){
        if(mgr==null){
            synchronized (PluginManager.class){
                if(mgr==null){
                    mgr = new PluginManager();
                }
            }
        }
        return mgr;
    }

    public <T> T getPlugin(String className, Class<T> required){
        Class<?> cls = null;
        try {
            cls = pluginClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("can not find class:"+className, e);
        }
        if(required.isAssignableFrom(cls)){
            try {
                return (T) cls.newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("can not newInstance class:"+className, e);
            }
        }
        throw new IllegalArgumentException("class:"+className+" not sub class of "+required);
    }

    public void addExternalJar(String basePath){
        if (StringUtils.isEmpty(basePath)) {
            throw new IllegalArgumentException("basePath can not be empty!");
        }
        File dir = new File(basePath);
        if(!dir.exists()){
            throw new IllegalArgumentException("basePath not exists:"+basePath);
        }
        if(!dir.isDirectory()){
            throw new IllegalArgumentException("basePath must be a directory:"+basePath);
        }

        if(!init){
            init= true;
            pluginClassLoader = doInit(basePath);
        }else{
            pluginClassLoader.addToClassLoader(basePath, null, true);
        }

    }

    private synchronized PluginClassLoader doInit(String basePath){
        return new PluginClassLoader(basePath);
    }
}

