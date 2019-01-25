package com.zhimzhou.DesignPatterns.lspPattern;

/**
 * @author zhimzhou
 * @since 2019/1/17 22:44
 */
public class MachineGun extends AbstractGun{
    @Override
    public void shoot() {
        System.out.println("机枪射击...");
    }
}
