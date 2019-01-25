package com.zhimzhou.DesignPatterns.TemplateMethodPattern;

/**
 * @author zhimzhou
 * @since 2019/1/20 21:25
 */
public class Client {
    public static void main(String[] args) {
        HummerH1Model h1 = new HummerH1Model();
        h1.setAlarm(false);
        HummerH2Model h2 = new HummerH2Model();
        h2.setAlarm(false);
        h1.run();
        h2.run();
        h1.setSequence("1111");
    }
}
