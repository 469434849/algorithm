package com.zhimzhou.DesignPatterns.FactoryMethodPattern;

/**
 * @author zhimzhou
 * @since 2019/1/20 16:59
 */
public class BlackHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("我是黑色肤色的人......");
    }

    @Override
    public void talk() {
        System.out.println("黑人说的话你们听不懂......");
    }
}
