package main.java.com.zhimzhou.designPatterns.TemplateMethodPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/20 21:21
 */
public abstract class HummerModel {
    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    public final void run() {
        this.start();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.engineBoom();
        this.stop();
    }

    protected boolean isAlarm() {
        return true;
    }

    final public void setSequence(String s) {
        System.out.println(s);
    }
}
