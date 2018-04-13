package com.wangerry.trietree;

import java.util.*;

class RandomString {
    private static HashMap<String, Integer> topWordList = new HashMap<>();
    static List<HashMap.Entry<String, Integer>> topWordSortedList;

    private static Random r;

    private static int minWordLength;
    private static int maxWordLength;

    static ArrayList<String> getStringsBySize(int totalSizeMB, int top, int minWordLength, int maxWordLength) {
        topWordList = new HashMap<>();
        r = new Random();
        long startTime = System.currentTimeMillis();

        RandomString.minWordLength = minWordLength;
        RandomString.maxWordLength = maxWordLength;
        // 平均字符长度
        int avgWordLength = (minWordLength + maxWordLength) / 2;
        // 高频词数量（占总数量20%）
        int topTotalSize = (int) (totalSizeMB * 1024 * 1024 * 0.2);
        // 高频词平均每个频率
        int avgTopFrequency = topTotalSize / top / avgWordLength;
        // 高频词频率
        int minFrequency = avgTopFrequency - 100;
        int maxFrequency = avgTopFrequency + 100;
        System.out.println("最低频率:" + minFrequency + "/最高频率" + maxFrequency);

        System.out.println("正在生成高频词");
        // 生成高频词
        getTopWord(top, minFrequency, maxFrequency);

        // 生成结果
        ArrayList<String> result = new ArrayList<>();
        long totalSizeMax = totalSizeMB * 1024 * 1024;
        long totalSizeCount = 0;
        // 写入高频词
        for (HashMap.Entry<String, Integer> kp : topWordList.entrySet()) {
            String key = kp.getKey();
            for (int i = 0; i < kp.getValue(); i++) {
                result.add(key);
            }
            totalSizeCount += kp.getKey().length() * kp.getValue();
        }

        System.out.println("正在生成随机词");
        do {
            // 获取随机词
            String rm = getRandomWord();
            // 获取随机频率
            int frequency = r.nextInt(minFrequency - 1) + 1;
            for (int i = 0; i < frequency; i++) {
                result.add(rm);
            }
            totalSizeCount += rm.length() * frequency;
        } while (totalSizeCount < totalSizeMax);


        System.out.println("正在打乱数组并生成结果" + result.size());
        // 随机打乱结果
        Collections.shuffle(result);
        System.out.println("生成完毕，耗时" + (System.currentTimeMillis() - startTime));

        return result;
    }

    // 获取随机字符串
    private static String getRandomWord() {
        int rLength = r.nextInt(maxWordLength - minWordLength) + minWordLength;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rLength; i++) {
            result.append((char) ('a' + r.nextInt(26)));
        }
        return result.toString();
    }

    // 生成高频词
    private static void getTopWord(int count, int minFrequency, int maxFrequency) {
        for (int i = 0; i < count; i++) {
            topWordList.put(getRandomWord(), r.nextInt(maxFrequency - minFrequency) + minFrequency);
        }
        topWordSortedList = new ArrayList<>(topWordList.entrySet());
        ValueComparator vc = new ValueComparator();
        topWordSortedList.sort(vc);
    }

    // 检查高频词是否正确
    static boolean checkTopWord(HashMap<String, Integer> checkList) {
        if (checkList.keySet().size() != topWordList.keySet().size()) {
            return false;
        } else {
            for (String key : checkList.keySet()) {
                if (topWordList.get(key).intValue() != checkList.get(key)) {
                    return false;
                }
            }
        }
        return true;
    }
}


















































