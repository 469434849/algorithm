package com.zhimzhou.DesignPatterns.FactoryMethodPattern;

/**
 * @author zhimzhou
 * @since 2019/1/20 17:09
 */
public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = HumanFactory.getInstance();
        BlackHuman blackHuman = humanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
        WhiteHuman whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        YellowHuman yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

    }
}
