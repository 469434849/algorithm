package com.zhimzhou.DesignPatterns.CommandPattern;

/**
 * @author zhimzhou
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
