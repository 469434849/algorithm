package com.wangerry.trietree;

import java.util.HashMap;
import java.util.List;

abstract class AutoTester {
    final void test() {
        boolean result;
        result = config(1, 20, 6, 16);
        if (!result) {
            System.out.println("结果错误，测试终止！");
            return;
        }
        result = config(100, 20, 6, 16);
        if (!result) {
            System.out.println("结果错误，测试终止！");
            return;
        }
        result = config(200, 10, 50, 100);
        if (!result) {
            System.out.println("结果错误，测试终止！");
            return;
        }
        result = config(200, 20, 6, 16);
        if (!result) {
            System.out.println("结果错误，测试终止！");
        }
    }

    private boolean config(int totalSizeMB, int top, int minWordLength, int maxWordLength) {
        System.out.println("=====================================================================");
        System.out.println("词组大小" + totalSizeMB + "MB/ 高频" + top + "词/ 单词长度" + minWordLength + "-" + maxWordLength);
        List<String> list = RandomString.getStringsBySize(totalSizeMB, top, minWordLength, maxWordLength);

        System.out.println("开始测试");
        long startTime = System.currentTimeMillis();
        boolean result = RandomString.checkTopWord(runner(list, top));
        long endTime = System.currentTimeMillis();
        System.out.println("结束测试");

        System.out.println("整体耗时" + (endTime - startTime));
        System.out.println("运算结果" + result);

        return result;
    }

    abstract HashMap<String, Integer> runner(List<String> stringList, int top);
}
