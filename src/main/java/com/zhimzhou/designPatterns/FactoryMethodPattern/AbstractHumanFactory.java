package main.java.com.zhimzhou.designPatterns.FactoryMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 17:02
 */
public abstract class AbstractHumanFactory {
    public abstract <T extends IHuman> T createHuman(Class<T> c);
}
