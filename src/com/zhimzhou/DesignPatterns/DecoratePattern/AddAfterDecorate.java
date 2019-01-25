package com.zhimzhou.DesignPatterns.DecoratePattern;

/**
 * @author zhimzhou
 * @since 2019/1/24 23:04
 */
public class AddAfterDecorate extends AbstractDecorator {
    public AddAfterDecorate(AbstractComponent component) {
        super(component);
    }

    private void addAfter() {
        System.out.println("after......");
    }

    @Override
    void operate() {
        super.operate();
        this.addAfter();
    }
}
