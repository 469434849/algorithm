package com.zhimzhou.DesignPatterns.ObserverPattern;

import java.util.Observable;

/**
 *
 * jdk 自带的被观察者
 *
 * @author zhimzhou
 * @since 2019/1/27 0:00
 */
public class JdkObservable extends Observable {

    public void doSomething(){
        System.out.println("使用jdk自带的被观察者正在在一些坏事......");
        super.setChanged();
        super.notifyObservers("被观察者正在干坏事......");
    }
}
