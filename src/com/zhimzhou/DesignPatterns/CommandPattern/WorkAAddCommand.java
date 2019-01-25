package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
 * @since 2019/1/22 23:03
 */
public class WorkAAddCommand extends Command {
    @Override
    public void exec() {
        super.workAGroup.addOneCommand();
    }
}
