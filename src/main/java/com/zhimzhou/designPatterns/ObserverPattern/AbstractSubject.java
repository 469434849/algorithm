package main.java.com.zhimzhou.designPatterns.ObserverPattern;

import java.util.Vector;

/**
 * 抽象的被观察者
 *
 * @author main.java.zhimzhou
 * @since 2019/1/26 23:46
 */
public class AbstractSubject {
    private Vector<IObserver> observers = new Vector<>();

    public void addObserver(IObserver observer){
        this.observers.add(observer);
    }

    public void remoteObserver(IObserver observer){
        this.observers.remove(observer);
    }

    public void notifyAllObervers(){
        for (IObserver observer : this.observers) {
            observer.update();
        }
    }
}
