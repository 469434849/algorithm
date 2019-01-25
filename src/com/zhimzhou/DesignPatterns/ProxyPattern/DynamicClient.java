package com.zhimzhou.DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zhimzhou
 * @since 2019/1/21 22:53
 */
public class DynamicClient {
    public static void main(String[] args) {
        Subject realSubject = new RealSubject("zhimzhou");
        InvocationHandler handler = new DynamicProxyHandle(realSubject);
        ClassLoader classLoader = realSubject.getClass().getClassLoader();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(classLoader, realSubject.getClass().getInterfaces(), handler);
        proxyInstance.doSomeThing();
    }
}
