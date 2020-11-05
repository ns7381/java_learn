package com.nathan.learn;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

class JettyServer {
    private static int PORT = 8089;

    private static int MAX_THREAD_NUM = 100;

    private static int MIN_THREAD_NUM = 50;

    private static int IDLE_THREAD_NUM = 20;
    // 启动jetty https服务
    public static void startJetty() {
        // 实例化Server 配置线程池参数
        Server server = new Server(new QueuedThreadPool(MAX_THREAD_NUM, MIN_THREAD_NUM, IDLE_THREAD_NUM));

        // 加载XML web配置文件
        WebAppContext webContext = new WebAppContext();
        server.setHandler(webContext);
        webContext.setContextPath("/");
        webContext.setResourceBase("./webapp");
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());

        // 配置通信通道
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });

        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭通道
            connector.close();
        }
    }

    public static void main(String[] args) {
        startJetty();
    }
}