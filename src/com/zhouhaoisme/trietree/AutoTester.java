package com.zhouhaoisme.trietree;

/**
 * @Author:zhouhao
 * @Date:2018/4/10
 * @Describe:
 */
import java.util.HashMap;
import java.util.List;

abstract class AutoTester {
    final void test() {
        boolean result;
        result = config(1, 20, 6, 16);
        if (!result) {
            System.out.println("������󣬲�����ֹ��");
            return;
        }
        result = config(100, 20, 6, 16);
        if (!result) {
            System.out.println("������󣬲�����ֹ��");
            return;
        }
        result = config(200, 10, 50, 100);
        if (!result) {
            System.out.println("������󣬲�����ֹ��");
            return;
        }
        result = config(200, 20, 6, 16);
        if (!result) {
            System.out.println("������󣬲�����ֹ��");
        }
    }

    private boolean config(int totalSizeMB, int top, int minWordLength, int maxWordLength) {
        System.out.println("=====================================================================");
        System.out.println("�����С" + totalSizeMB + "MB/ ��Ƶ" + top + "��/ ���ʳ���" + minWordLength + "-" + maxWordLength);
        List<String> list = RandomString.getStringsBySize(totalSizeMB, top, minWordLength, maxWordLength);

        System.out.println("��ʼ����");
        long startTime = System.currentTimeMillis();
        boolean result = RandomString.checkTopWord(runner(list, top));
        long endTime = System.currentTimeMillis();
        System.out.println("��������");

        System.out.println("�����ʱ" + (endTime - startTime));
        System.out.println("������" + result);


        return result;
    }

    abstract HashMap<String, Integer> runner(List<String> stringList, int top);
}

