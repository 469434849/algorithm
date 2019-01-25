package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
 * @since 2019/1/22 22:58
 */
public class Invoker {
    /**
     * 实施者发布命令
     */
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void action(){
        this.command.exec();
    }
}
