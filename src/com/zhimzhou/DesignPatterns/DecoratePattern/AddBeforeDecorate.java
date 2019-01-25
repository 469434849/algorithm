package com.zhimzhou.DesignPatterns.DecoratePattern;

/**
 * @author zhimzhou
 * @since 2019/1/24 23:03
 */
public class AddBeforeDecorate extends AbstractDecorator {

    public AddBeforeDecorate(AbstractComponent component) {
        super(component);
    }

    private void before() {
        System.out.println("before......");
    }

    @Override
    void operate() {
        this.before();
        super.operate();
    }
}
