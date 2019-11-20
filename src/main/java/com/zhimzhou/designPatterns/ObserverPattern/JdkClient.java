package main.java.com.zhimzhou.designPatterns.ObserverPattern;

import java.util.Observer;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/27 0:06
 */
public class JdkClient {
    public static void main(String[] args) {
        JdkObservable jdkObservable = new JdkObservable();
        Observer jdkObserver = new JdkObserver();
        jdkObservable.addObserver(jdkObserver);
        jdkObservable.doSomething();
    }
}
