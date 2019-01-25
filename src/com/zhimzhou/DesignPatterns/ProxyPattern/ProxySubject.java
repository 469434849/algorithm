package com.zhimzhou.DesignPatterns.ProxyPattern;

/**
 * @author zhimzhou
 * @since 2019/1/21 22:08
 */
public class ProxySubject implements Subject,IProxy {
    private Subject subject = null;

    public ProxySubject() {
        this.subject = new ProxySubject();
    }

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public ProxySubject(String name) {
        try {
            subject = new RealSubject(this, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doSomeThing() {
        this.before();
        this.subject.doSomeThing();
        this.after();
        this.count();
    }

    @Override
    public void count() {
        System.out.println("使用代理了，收费100$");
    }

    private void before() {
        System.out.println("proxy before.");
    }

    private void after() {
        System.out.println("proxy after");
    }
}
