package com.zhimzhou.DesignPatterns.DecoratePattern;

/**
 * @author zhimzhou
 * @since 2019/1/24 23:05
 */
public class Client {
    public static void main(String[] args) {
        AbstractComponent component = new ConcreteComponent();
        component.operate();
        component = new AddBeforeDecorate(component);
        //component.operate();
        component = new AddAfterDecorate(component);
        component.operate();
    }
}
