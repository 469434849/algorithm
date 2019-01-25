package com.zhimzhou.DesignPatterns.FactoryMethodPattern;

/**
 * @author zhimzhou
 * @since 2019/1/20 17:04
 */
public class HumanFactory extends AbstractHumanFactory {
    private static final HumanFactory instance = new HumanFactory();

    private HumanFactory() {
    }

    public static HumanFactory getInstance() {
        return instance;
    }

    @Override
    public <T extends IHuman> T createHuman(Class<T> c) {
        IHuman iHuman = null;
        try {
            iHuman = (IHuman) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) iHuman;
    }
}
