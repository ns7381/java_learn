package com.concurent.jdk.thread;

public class TestThread6 {
	public static void main(String args[]){
		Thread t = new Runner6();
   	t.start();

		for(int i=0; i<50; i++) {
			System.out.println("MainThread: " + i);
		}
  }
}

class Runner6 extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().isAlive());
		for(int i=0;i<50;i++) {
			System.out.println("SubThread: " + i);
		}
	}
}
