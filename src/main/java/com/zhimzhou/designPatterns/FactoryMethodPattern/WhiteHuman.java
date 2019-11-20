package main.java.com.zhimzhou.designPatterns.FactoryMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 17:00
 */
public class WhiteHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("白色皮肤的人......");
    }

    @Override
    public void talk() {
        System.out.println("白种人说英语......");
    }
}
