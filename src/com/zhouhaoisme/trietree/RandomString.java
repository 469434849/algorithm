package com.zhouhaoisme.trietree;
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
        // ƽ���ַ�����
        int avgWordLength = (minWordLength + maxWordLength) / 2;
        // ��Ƶ��������ռ������20%��
        int topTotalSize = (int) (totalSizeMB * 1024 * 1024 * 0.2);
        // ��Ƶ��ƽ��ÿ��Ƶ��
        int avgTopFrequency = topTotalSize / top / avgWordLength;
        // ��Ƶ��Ƶ��
        int minFrequency = avgTopFrequency - 100;
        int maxFrequency = avgTopFrequency + 100;
        System.out.println("���Ƶ��:" + minFrequency + "/���Ƶ��" + maxFrequency);

        System.out.println("�������ɸ�Ƶ��");
        // ���ɸ�Ƶ��
        getTopWord(top, minFrequency, maxFrequency);

        // ���ɽ��
        ArrayList<String> result = new ArrayList<>();
        long totalSizeMax = totalSizeMB * 1024 * 1024;
        long totalSizeCount = 0;
        // д���Ƶ��
        for (HashMap.Entry<String, Integer> kp : topWordList.entrySet()) {
            String key = kp.getKey();
            for (int i = 0; i < kp.getValue(); i++) {
                result.add(key);
            }
            totalSizeCount += kp.getKey().length() * kp.getValue();
        }

        System.out.println("�������������");
        do {
            // ��ȡ�����
            String rm = getRandomWord();
            // ��ȡ���Ƶ��
            int frequency = r.nextInt(minFrequency - 1) + 1;
            for (int i = 0; i < frequency; i++) {
                result.add(rm);
            }
            totalSizeCount += rm.length() * frequency;
        } while (totalSizeCount < totalSizeMax);


        System.out.println("���ڴ������鲢���ɽ��" + result.size());
        // ������ҽ��
        Collections.shuffle(result);
        System.out.println("������ϣ���ʱ" + (System.currentTimeMillis() - startTime));

        return result;
    }

    // ��ȡ����ַ���
    private static String getRandomWord() {
        int rLength = r.nextInt(maxWordLength - minWordLength) + minWordLength;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rLength; i++) {
            result.append((char) ('a' + r.nextInt(26)));
        }
        return result.toString();
    }

    // ���ɸ�Ƶ��
    private static void getTopWord(int count, int minFrequency, int maxFrequency) {
        for (int i = 0; i < count; i++) {
            topWordList.put(getRandomWord(), r.nextInt(maxFrequency - minFrequency) + minFrequency);
        }
        topWordSortedList = new ArrayList<>(topWordList.entrySet());
        ValueComparator vc = new ValueComparator();
        topWordSortedList.sort(vc);
    }

    // ����Ƶ���Ƿ���ȷ
    static boolean checkTopWord(HashMap<String, Integer> checkList) {


//        System.out.println("��ȷ���");
//        for(HashMap.Entry<String,Integer> akv : topWordList.entrySet()){
//            System.out.println(akv.getKey() + "\t" + akv.getValue());
//        }
//
//        System.out.println("�ҵĽ��");
//        for(HashMap.Entry<String,Integer> akv : checkList.entrySet()){
//            System.out.println(akv.getKey() + "\t" + akv.getValue());
//        }

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

class ValueComparator implements Comparator<HashMap.Entry<String, Integer>> {
    @Override
    public int compare(HashMap.Entry<String, Integer> m, HashMap.Entry<String, Integer> n) {
        return n.getValue() - m.getValue();
    }
}
