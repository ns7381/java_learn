package com.design.structural.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyProxy {
    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler handler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String src = generateSrc(interfaces);
        File file = new File(MyProxy.class.getResource("").getPath() + "$Proxy0.java");
        FileWriter writer = new FileWriter(file);
        writer.write(src);
        writer.flush();
        writer.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);

        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();

        Class<?> proxy0 = classLoader.findClass("$Proxy0");
        Constructor<?> constructor = proxy0.getConstructor(MyInvocationHandler.class);
        return constructor.newInstance(handler);
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.design.proxy.custom;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("private MyInvocationHandler h;" + ln);
        sb.append("public $Proxy0(MyInvocationHandler h) { " + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + " "
                    + m.getName() + "() {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName()
                    + ".class.getMethod(\"" + m.getName()
                    + "\",new Class[]{});" + ln);
            sb.append("return ("+m.getReturnType().getName()+")this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}" + ln);
            sb.append("return null;" + ln);
            sb.append("}" + ln);
        }
        sb.append("}" + ln);
        return sb.toString();
    }
}
