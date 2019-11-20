package main.java.com.zhimzhou.designPatterns.TemplateMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 21:24
 */
public class HummerH2Model extends HummerModel {
    private Boolean isAlarm = true;

    public void setAlarm(Boolean alarm) {
        this.isAlarm = alarm;
    }

    @Override
    protected void start() {
        System.out.println("h2 start......");
    }

    @Override
    protected void stop() {
        System.out.println("h2 stop......");
    }

    @Override
    protected void alarm() {
        System.out.println("h2 alarm......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("h2 boom......");
    }

    @Override
    protected boolean isAlarm() {
        return this.isAlarm;
    }
}
