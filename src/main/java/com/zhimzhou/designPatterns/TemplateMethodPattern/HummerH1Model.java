package main.java.com.zhimzhou.designPatterns.TemplateMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 21:23
 */
public class HummerH1Model extends HummerModel {
    private Boolean isAlarm = true;

    @Override
    protected void start() {
        System.out.println("h1 start......");
    }

    @Override
    protected void stop() {
        System.out.println("h1 stop......");
    }

    @Override
    protected void alarm() {
        System.out.println("h1 alarm......");
    }

    @Override
    protected void engineBoom() {
        System.out.println("h1 boom......");
    }

    @Override
    protected boolean isAlarm() {
        return this.isAlarm;
    }

    public void setAlarm(Boolean alarm) {
        this.isAlarm = alarm;
    }


}
