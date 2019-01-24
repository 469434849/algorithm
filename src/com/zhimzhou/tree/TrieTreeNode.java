package com.zhimzhou.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * Trie Tree结
 */
public class TrieTreeNode {
	private HashMap<Character, TrieTreeNode> childes = new HashMap<>();
	private TrieTreeNode failure = null;
	private boolean isEndNode = false;
	private String save;
	private char value;
	private int type;

	public boolean addChild(String str, int type) {
		TrieTreeNode node = this;
		boolean addStatus = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (node.childes.containsKey(c)) {
				node = node.childes.get(c);
			} else {
				TrieTreeNode tempNode = new TrieTreeNode();
				tempNode.value = c;
				node.childes.put(c, tempNode);
				node = tempNode;
			}
			if (i == str.length() - 1) {
				if (!node.isEndNode) {
					node.isEndNode = true;
					addStatus = true;
					node.save = str;
					node.type = type;
				}
			}
		}

		return addStatus;
	}

	/**
	 * BFS生成failure指针
	 */
	public void makeFailure() {
		TrieTreeNode root = this;
		Stack<TrieTreeNode> stack = new Stack<>();
		TrieTreeNode currentNode;
		stack.push(this);

		while (!stack.empty()) {
			currentNode = stack.pop();
			for (TrieTreeNode n : currentNode.childes.values()) {
				stack.push(n);
				if (currentNode.failure == null) {
					n.failure = root;
				} else {
					TrieTreeNode point = currentNode.failure;
					while (point != null) {
						if (point.childes.containsKey(n.value)) {
							n.failure = point.childes.get(n.value);
							break;
						}
						point = point.failure;
					}
					if (point == null) {
						n.failure = root;
					}
				}
			}
		}
	}

	/**
	 * 多模匹配
	 *
	 * @param str 源字符串
	 * @return 匹配的目标字符串
	 */
	public String replace(String str, char replace) {
		TrieTreeNode root = this;
		TrieTreeNode point = this;
		char[] charArray = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			char c = charArray[i];
			while (!point.childes.containsKey(c) && !point.equals(root)) {
				point = point.failure;
			}
			if (point.childes.containsKey(c)) {
				point = point.childes.get(c);

				// 匹配全部类型
				TrieTreeNode t = point;
				while (!t.equals(root)) {
					if (t.isEndNode) {
						for (int j = 0; j < t.save.length(); j++) {
							charArray[i - j] = replace;
						}
					}
					t = t.failure;
				}
			}
		}

		return new String(charArray);
	}

}
