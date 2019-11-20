package main.java.com.zhimzhou.designPatterns.BuilderPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 22:08
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("benz start");
    }

    @Override
    protected void stop() {
        System.out.println("benz stop");
    }

    @Override
    protected void alarm() {
        System.out.println("benz alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("benz engineBoom");
    }
}
