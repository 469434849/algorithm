package com.zhouhaoisme.trietree;

import java.util.*;

/**
 * @Author:zhouhao
 * @Date:2018/4/10
 * @Describe:
 */
class TrieNode {
    boolean isWord;
    Integer count;
    String word;
    Map<Character, TrieNode> content;

    public TrieNode() {
        content = new HashMap<>();
        count = new Integer(0);
        word = new String();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        TrieNode tempNode;
        for (int i = 0, len = word.length(); i < len; i++) {
            Character c = word.charAt(i);
            tempNode = node.content.get(c);
            if (tempNode == null) {
                tempNode = new TrieNode();
                node.content.put(c, tempNode);
            }
            node = tempNode;
        }
        node.count++;
        node.isWord = true;
        node.word = new String(word);
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode node = root;
        TrieNode tempNode;
        for (int i = 0, len = word.length(); i < len; i++) {
            Character c = word.charAt(i);
            tempNode = node.content.get(c);
            if (tempNode == null) {
                return false;
            }
            node = tempNode;
        }
        return node.isWord;
    }

    public HashMap<String, Integer> traverse(TrieNode root, Integer top) {
        if (root == null) {
            System.out.println("root is null.");
            return null;
        }

        HashMap<String, Integer> maps = new HashMap<>();
        Map<String, Integer> allNode = getAllNode(root, maps);

        List<Map.Entry<String, Integer>> list = sortmapByValue(allNode);
        maps.clear();
        for (int i = 0; i < top; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            maps.put(entry.getKey(),entry.getValue());
        }
        return maps;
    }

    public static Map<String, Integer> getAllNode(TrieNode root, Map<String, Integer> map) {
        if (root == null) {
            System.out.println("root is null.");
            return null;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<Character, TrieNode> contentMap = root.content;
        Set<Character> keys = contentMap.keySet();
        Iterator<Character> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            TrieNode trieNode = contentMap.get(next);
            if (trieNode.isWord) {
                map.put(trieNode.word, trieNode.count);
            }
            getAllNode(trieNode, map);
        }
        return map;
    }

    public static  List<Map.Entry<String, Integer>> sortmapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> -1*o1.getValue().compareTo(o2.getValue()));
        return list;
    }

    public static void main(String[] args) throws Exception {
        Thread.sleep(10*2000);

        AutoTester autoTester = new AutoTester() {
            @Override
            HashMap<String, Integer> runner(List<String> stringList, int top) {
                Trie trie = new Trie();
                for (String str : stringList) {
                    trie.insert(str);
                }
                return trie.traverse(trie.root, top);
            }
        };
        autoTester.test();
    }
}
