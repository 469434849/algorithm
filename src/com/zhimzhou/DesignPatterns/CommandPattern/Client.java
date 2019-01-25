package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
 * @since 2019/1/22 23:04
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new WorkBModifyCommand());
        invoker.action();
        invoker.setCommand(new WorkAAddCommand());
        invoker.action();
    }
}
