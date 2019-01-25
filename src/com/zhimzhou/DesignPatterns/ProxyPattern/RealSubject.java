package com.zhimzhou.DesignPatterns.ProxyPattern;

/**
 * @author zhimzhou
 * @since 2019/1/21 22:08
 */
public class RealSubject implements Subject {

    private String name = "";

    public RealSubject(String name) {
        this.name = name;
    }

    public RealSubject(Subject subject, String name) throws Exception {
        if (subject == null) {
            throw new Exception("subject can not be null.");
        } else {
            this.name = name;
        }
    }

    @Override
    public void doSomeThing() {
        System.out.println(name + "\ti am real subject do......");
    }
}
