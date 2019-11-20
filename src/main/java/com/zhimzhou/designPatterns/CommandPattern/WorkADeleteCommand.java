package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 23:02
 */
public class WorkADeleteCommand extends Command{
    @Override
    public void exec() {
        super.workAGroup.deleteOneCommand();
    }
}
