package com.zhimzhou.DesignPatterns.DecoratePattern;

/**
 * @author zhimzhou
 * @since 2019/1/24 23:01
 */
public class AbstractDecorator extends AbstractComponent {
    private AbstractComponent component;

    //通过构造函数传递被装饰者
    public AbstractDecorator(AbstractComponent component) {
        this.component = component;
    }

    //委托给被装饰者执行
    @Override
    void operate() {
        this.component.operate();
    }
}
