package com.nathan.learn.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * UnicastRemoteObject会生成一个代理proxy
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    public RmiServiceImpl() throws RemoteException {
    }

    @Override
    public String hello(String name) throws RemoteException {
        return "Hello " + name;
    }
}
