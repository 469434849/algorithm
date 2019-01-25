package com.zhimzhou.Demo;

import java.util.ArrayList;

/**
 * @author zhimzhou
 * @since 2019/1/24 23:45
 */
public class Client {
    public static void main(String[] args) {

        ArrayList<? extends Fruit> lists = new ArrayList<Apple>();

        ArrayList<? super Apple> list = new ArrayList<Fruit>();
     }
}
