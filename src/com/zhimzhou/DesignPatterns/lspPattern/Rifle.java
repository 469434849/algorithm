package com.zhimzhou.DesignPatterns.lspPattern;

/**
 * @author zhimzhou
 * @since 2019/1/17 22:43
 */
public class Rifle extends AbstractGun {
    @Override
    public void shoot() {
        System.out.println("步枪射击...");
    }
}
