package main.java.com.zhimzhou.designPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 22:16
 */
public abstract class CarBuilder {
    public abstract CarBuilder setSequence(ArrayList<String> list);

    public abstract CarModel builder();
}
