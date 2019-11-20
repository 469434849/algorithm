package main.java.com.zhimzhou.designPatterns.CommandPattern;

/**
 * @author main.java.zhimzhou
 * @since 2019/1/22 23:03
 */
public class WorkBModifyCommand extends Command {
    @Override
    public void exec() {
        super.workBGroup.modifyOneCommand();
    }
}
