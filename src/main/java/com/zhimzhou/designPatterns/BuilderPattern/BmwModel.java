package main.java.com.zhimzhou.designPatterns.BuilderPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 22:07
 */
public class BmwModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("bmw start");
    }

    @Override
    protected void stop() {
        System.out.println("bmw stop");
    }

    @Override
    protected void alarm() {
        System.out.println("bmw alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("bmw boom");
    }
}
