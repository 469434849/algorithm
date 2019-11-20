package main.java.com.zhimzhou.designPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 22:17
 */
public class BmwBuilder extends CarBuilder {
    private BmwModel bmwModel = new BmwModel();

    @Override
    public CarBuilder setSequence(ArrayList<String> list) {
        this.bmwModel.setSequence(list);
        return this;
    }

    @Override
    public CarModel builder() {
        return this.bmwModel;
    }
}
