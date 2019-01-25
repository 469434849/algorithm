package com.zhimzhou.DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 * @author zhimzhou
 * @since 2019/1/20 22:16
 */
public abstract class CarBuilder {
    public abstract CarBuilder setSequence(ArrayList<String> list);

    public abstract CarModel builder();
}
