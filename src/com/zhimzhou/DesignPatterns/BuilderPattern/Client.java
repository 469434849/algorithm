package com.zhimzhou.DesignPatterns.BuilderPattern;

import java.util.ArrayList;

/**
 * @author zhimzhou
 * @since 2019/1/20 22:09
 */
public class Client {
    public static void main(String[] args) {
        BenzModel benzModel = new BenzModel();
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("start");
        sequence.add("stop");
        sequence.add("alarm");
        sequence.add("engineBoom");
        sequence.add("alarm");
        benzModel.setSequence(sequence);
        //benzModel.run();

        new BmwBuilder().setSequence(sequence).builder().run();
        new BenzBuilder().setSequence(sequence).builder().run();
    }
}
