package com.zhimzhou.DesignPatterns.ObserverPattern;

/**
 * 具体被观察者
 *
 * @author zhimzhou
 * @since 2019/1/26 23:51
 */
public class ConcreteSubject extends AbstractSubject {

    public void doSomething(){
        System.out.println("被观察者正在干坏事......");
        super.notifyAllObervers();
    }
}
