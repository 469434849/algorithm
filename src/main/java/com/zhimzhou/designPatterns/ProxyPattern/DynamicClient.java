package main.java.com.zhimzhou.designPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/21 22:53
 */
public class DynamicClient {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject("main/java/com/zhimzhou");
        InvocationHandler handler = new DynamicProxyHandle(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(classLoader, realSubject.getClass().getInterfaces(), handler);
        proxyInstance.doSomeThing();
    }
}
