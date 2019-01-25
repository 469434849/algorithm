package com.zhimzhou.DesignPatterns.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhimzhou
 * @since 2019/1/21 22:51
 */
public class DynamicProxyHandle implements InvocationHandler {

    public Object targetObject;

    public DynamicProxyHandle(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1111");
        Object result = method.invoke(this.targetObject, args);
        System.out.println("2222");
        return result;
    }
}
