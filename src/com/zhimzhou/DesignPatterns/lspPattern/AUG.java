package com.zhimzhou.DesignPatterns.lspPattern;

/**
 * @author zhimzhou
 * @since 2019/1/17 22:52
 */
public class AUG extends Rifle {

    public void zoomout(){
        System.out.println("正在瞄准....");
    }

    @Override
    public void shoot() {
        System.out.println("AUG...射击.");
    }
}
