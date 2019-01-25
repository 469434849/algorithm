package com.zhimzhou.DesignPatterns.ProxyPattern;

/**
 * @author zhimzhou
 * @since 2019/1/21 22:10
 */
public class Client {
    public static void main(String[] args) {
        Subject proxySubject = new ProxySubject("zhimzhou");
        proxySubject.doSomeThing();
    }
}
