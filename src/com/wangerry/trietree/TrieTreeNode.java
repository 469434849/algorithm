package com.wangerry.trietree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieTreeNode {
    private boolean isEndNode = false;
    private char value;
    private int count = 0;
    private boolean visited = false;
    private HashMap<Character, TrieTreeNode> childs = new HashMap<>();

    void addChild(String str) {
        TrieTreeNode node = this;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.childs.containsKey(c)) {
                node = node.childs.get(c);
            } else {
                TrieTreeNode tempNode = new TrieTreeNode();
                tempNode.value = c;
                node.childs.put(c, tempNode);
                node = tempNode;
            }
            if (i == str.length() - 1) {
                node.count++;
                node.isEndNode = true;
            }
        }

    }

    HashMap<String, Integer> getStringList() {
        HashMap<String, Integer> result = new HashMap<>();
        List<TrieTreeNode> nodeStack = new ArrayList<>();
        nodeStack.add(this);
        StringBuilder newSb = new StringBuilder();
        TrieTreeNode currentNode = this;

        while (nodeStack.size() != 0) {
            boolean tag = false;
            for (Map.Entry<Character, TrieTreeNode> aKv : currentNode.childs.entrySet()) {
                if (!aKv.getValue().visited) {
                    currentNode = aKv.getValue();
                    nodeStack.add(currentNode);
                    newSb.append(currentNode.value);
                    tag = true;
                    break;
                }
            }
            if (!tag) {
                if (currentNode.isEndNode) {
                    result.put(newSb.toString(), currentNode.count);
                }
                // 回退
                currentNode.visited = true;
                nodeStack.remove(nodeStack.size() - 1);
                if (nodeStack.size() == 0) break;
                currentNode = nodeStack.get(nodeStack.size() - 1);
                newSb.deleteCharAt(newSb.length() - 1);
            }
        }


        return result;
    }
}
