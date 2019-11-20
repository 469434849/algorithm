package main.java.com.zhimzhou.designPatterns.ObserverPattern;

/**
 * 具体观察者
 *
 * @author main.java.zhimzhou
 * @since 2019/1/26 23:52
 */
public class ConcreteObserve implements IObserver {
    @Override
    public void update() {
        System.out.println("观察者收到信息，处理......");
    }
}
