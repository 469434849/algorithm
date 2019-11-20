package main.java.com.zhimzhou.designPatterns.DecoratePattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/24 23:05
 */
public class Client {
    public static void main(String[] args) {
        AbstractComponent component = new ConcreteComponent();
        component.operate();
        component = new AddBeforeDecorate(component);
        //component.operate();
        component = new AddAfterDecorate(component);
        component.operate();
    }
}
