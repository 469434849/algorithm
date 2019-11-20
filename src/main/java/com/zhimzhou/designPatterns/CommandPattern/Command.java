package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 22:53
 */
public abstract class Command {

    /**
     * 需要执行命令的人
     */
    WorkAGroup workAGroup = new WorkAGroup();
    WorkBGroup workBGroup = new WorkBGroup();

    public abstract void exec();
}
