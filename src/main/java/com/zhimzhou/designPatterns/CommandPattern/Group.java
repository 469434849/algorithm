package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 22:55
 */
public abstract class Group {
    /**
     * 定义基本工作
     */
    protected abstract void addOneCommand();
    protected abstract void modifyOneCommand();
    protected abstract void deleteOneCommand();
}
