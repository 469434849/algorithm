package main.java.com.zhimzhou.designPatterns.FactoryMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 17:09
 */
public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = HumanFactory.getInstance();
        WhiteHuman whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();
        YellowHuman yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

    }
}
