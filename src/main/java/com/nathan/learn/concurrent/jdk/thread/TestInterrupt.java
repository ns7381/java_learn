package com.nathan.learn.concurrent.jdk.thread;

import java.util.*;

public class TestInterrupt {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        thread.interrupt();
    }
}

class MyThread extends Thread {
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("===" + new Date() + "===");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
/*
public void run() {
    while (true) {
      String temp = new Date().toString();
      String t = temp.substring(11, temp.indexOf('C'));
      t = t.trim();
      String[] time = t.split(":");
      if (time.length == 3) {
        System.out.println(“现在是” + time[0] + “点” +
                  time[1] + "分" + time[2] + "秒");
      }
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        return;
      }
    }
  }
}
*/
