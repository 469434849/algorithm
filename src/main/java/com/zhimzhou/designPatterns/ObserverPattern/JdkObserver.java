package main.java.com.zhimzhou.designPatterns.ObserverPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用jdk自带的观察者
 *
 * @author main.java.zhimzhou
 * @since 2019/1/27 0:02
 */
public class JdkObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("收到被观察者:"+o.toString()+"\t"+arg.toString());
        System.out.println("正在处理....");
    }
}
