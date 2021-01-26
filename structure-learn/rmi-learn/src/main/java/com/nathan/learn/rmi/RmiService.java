package com.nathan.learn.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 接口必须继承RMI的Remote
 */
public interface RmiService extends Remote {

    /**
     * 必须有RemoteException，才是RMI方法
     */
    String hello(String name) throws RemoteException;
}
