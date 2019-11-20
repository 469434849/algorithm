package main.java.com.zhimzhou.designPatterns.ObserverPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/26 23:54
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        IObserver observer1 = new ConcreteObserve();
        concreteSubject.addObserver(observer1);
        concreteSubject.doSomething();
    }
}
