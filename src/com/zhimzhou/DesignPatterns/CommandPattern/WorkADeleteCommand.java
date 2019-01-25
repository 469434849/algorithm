package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
 * @since 2019/1/22 23:02
 */
public class WorkADeleteCommand extends Command{
    @Override
    public void exec() {
        super.workAGroup.deleteOneCommand();
    }
}
