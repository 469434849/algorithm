package main.java.com.zhimzhou.designPatterns.FactoryMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 17:01
 */
public class YellowHuman implements IHuman {
    @Override
    public void getColor() {
        System.out.println("黄种人皮肤是黄色的......");
    }

    @Override
    public void talk() {
        System.out.println("黄种人说汉语......");
    }
}
