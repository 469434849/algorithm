package com.wangerry.trietree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20*1000);
        AutoTester tester = new AutoTester() {
            @Override
            HashMap<String, Integer> runner(List<String> stringList, int top) {
                TrieTreeNode node = new TrieTreeNode();
                for (String aList : stringList) {
                    node.addChild(aList);
                }
                HashMap<String, Integer> result = node.getStringList();
                List<HashMap.Entry<String, Integer>> sortedResult = new ArrayList<>(result.entrySet());
                ValueComparator vc = new ValueComparator();
                sortedResult.sort(vc);
                return getResult(sortedResult, top);
            }

            private HashMap<String, Integer> getResult(List<HashMap.Entry<String, Integer>> kv, int top) {
                HashMap<String, Integer> result = new HashMap<>();
                int js = 0;
                for (int i = 0; i < top; i++) {
                    result.put(kv.get(i).getKey(), kv.get(i).getValue());
                }
                return result;
            }
        };
        tester.test();
//
//        ArrayList<String> list = RandomString.getStringsBySize(1, 20, 6, 16);
//        System.out.println("随机字符标准结果");
//        printList(RandomString.topWordSortedList);
//
//        long StartTime = System.currentTimeMillis();
//        System.out.println("生成Trie Tree结构");
//        TrieTreeNode node = new TrieTreeNode("");
//        for (String aList : list) {
//            node.addChild(aList);
//        }
//
//        System.out.println("运算结果");
//        StringBuilder sb = new StringBuilder();
//        HashMap<String, Integer> result = node.getStringList(sb);
//        List<HashMap.Entry<String, Integer>> sortedResult = new ArrayList<>(result.entrySet());
//        ValueComparator vc = new ValueComparator();
//        sortedResult.sort(vc);
//        printList(sortedResult);
//        long EndTime = System.currentTimeMillis();
//
//        System.out.println("运算时间:" + (EndTime - StartTime));
    }


    private static void printList(List<HashMap.Entry<String, Integer>> kv) {
        int js = 0;
        for (Map.Entry<String, Integer> aKv : kv) {
            System.out.println(aKv.getKey() + "\t" + aKv.getValue());
            js++;
            if (js == 20) return;
        }
    }

    private static HashMap<String, Integer> getResult(List<HashMap.Entry<String, Integer>> kv, int top) {
        HashMap<String, Integer> result = new HashMap<>();
        int js = 0;
        for (Map.Entry<String, Integer> aKv : kv) {
            result.put(aKv.getKey(), aKv.getValue());
            js++;
            if (js == top) break;
        }
        return result;
    }
}
