package main.java.com.zhimzhou.designPatterns.FactoryMethodPattern;

import java.lang.reflect.Constructor;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 17:26
 */
public class Main {
    private static HumanFactory humanFactory;

    static {
        try {
            Class c = Class.forName(HumanFactory.class.getName());
            Constructor constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            humanFactory = (HumanFactory) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(humanFactory.hashCode());
    }
}
