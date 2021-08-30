package com.nathan.learn.base.jvm;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class SignalTest {

    public static void main(String[] args) throws InterruptedException {
        SignalHandler signalHandler = signal -> System.out.println("SignalHandler: " + signal);
        // 只有kill -9能够结束jvm进程，别的信号量只是发送给java进程处理，至于如何响应是程序代码决定的
        Signal.handle(new Signal("HUP"), signalHandler); // kill -1 PID
//        Signal.handle(new Signal("INT"), signalHandler); // kill -2 PID
        // already used by VM or OS: SIGQUIT
        //对于SIGQUIT(kill -3)，jvm会捕获该信号并dump线程栈到标准错误流，不会产生core-dump文件；这个信号的处理方式是系统保留用户无法修改:
//         Signal.handle(new Signal("QUIT"), signalHandler); // kill -3 PID
        Signal.handle(new Signal("ABRT"), signalHandler); // kill -6 PID
        // already used by VM or OS: SIGKILL
        //对于SIGQUIT(kill -3)，jvm会捕获该信号并dump线程栈到标准错误流，不会产生core-dump文件；这个信号的处理方式是系统保留用户无法修改:
//         Signal.handle(new Signal("KILL"), signalHandler); // kill -9 PID
        Signal.handle(new Signal("ALRM"), signalHandler); // kill -14 PID
        Signal.handle(new Signal("TERM"), signalHandler); // kill -15 PID

        //触发shutdown hook的singals
        //SIGTERM(kill), SIGINT(kill -2), SIGHUP(kill -1) 会触发shutdown hook的执行。
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("ok")));
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
    }
}
