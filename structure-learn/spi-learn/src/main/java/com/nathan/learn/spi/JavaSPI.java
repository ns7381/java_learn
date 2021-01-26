package com.nathan.learn.spi;

import com.sun.tools.javac.util.ServiceLoader;

import java.util.Iterator;

public class JavaSPI {
    public static void main(String[] args) {
        ServiceLoader<RunService> services = ServiceLoader.load(RunService.class);
        Iterator<RunService> serviceIterator = services.iterator();
        while (serviceIterator.hasNext()) {
            System.out.println(serviceIterator.next().run());
        }
    }
}
