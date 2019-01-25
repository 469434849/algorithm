package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
 * @since 2019/1/22 23:03
 */
public class WorkBModifyCommand extends Command {
    @Override
    public void exec() {
        super.workBGroup.modifyOneCommand();
    }
}
