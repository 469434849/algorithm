package main.java.com.zhimzhou.designPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 22:22
 */
public class BenzBuilder extends CarBuilder {
    private BenzModel benzModel = new BenzModel();

    @Override
    public CarBuilder setSequence(ArrayList<String> list) {
        this.benzModel.setSequence(list);
        return this;
    }

    @Override
    public CarModel builder() {
        return this.benzModel;
    }
}
