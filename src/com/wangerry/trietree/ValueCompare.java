package com.wangerry.trietree;


import java.util.Comparator;
import java.util.HashMap;

// 用于排序的比较器
class ValueComparator implements Comparator<HashMap.Entry<String, Integer>> {
    @Override
    public int compare(HashMap.Entry<String, Integer> m, HashMap.Entry<String, Integer> n) {
        return n.getValue() - m.getValue();
    }
}