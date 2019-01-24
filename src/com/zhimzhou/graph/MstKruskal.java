package com.zhimzhou.graph;

import java.util.ArrayList;

/**
 * kruskal最小生成树,核心判断是否形成环，利用（并查集概念）
 * 基本思想:以边为核心，将各个边按照小到大排序，排序算法随意，按照排序后的边的集合遍历，
 * 初始化每个顶点的源(root)为自身，当选取了某些边的时候，
 * 判断该边所连接的两个顶点的源信息是否为同一个
 * 是：抛弃该边，继续执行下一条
 * 否：将该边加入到最终结果中，并更新这两个顶点的源（root）数据信息
 * 直到获取边的数目为顶点数目 - 1，遍历结束，最小生成树找到
 *
 * @author zhimzhou
 * @date 2019/1/24 15:13
 **/
public class MstKruskal {

	private static final char[] VERTICES = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G'
	};

	static class Node implements Comparable<Node> {
		char v1;
		char v2;
		int weight;

		public Node(char v1, char v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}

	static final Node[] EDGES = new Node[]{
			new Node('A', 'B', 12),
			new Node('A', 'F', 16),
			new Node('A', 'G', 14),
			new Node('B', 'C', 10),
			new Node('B', 'F', 7),
			new Node('C', 'D', 3),
			new Node('C', 'E', 5),
			new Node('C', 'F', 6),
			new Node('D', 'E', 4),
			new Node('E', 'F', 2),
			new Node('E', 'G', 8),
			new Node('F', 'G', 9),
	};

	public static void main(String[] args) {
		Node[] nodes = EDGES;
		sortEdgesByWeight(nodes);
		printKruskalWeight(nodes);
		mst(nodes);
	}

	public static void mst(Node[] edges) {
		//初始化顶点,这里为了方便，就直接默认知道各个顶点
		//char[] mVertices = VERTICES;
		//初始化各个顶点源信息，默认为自身
		char[] mVerticesRoot = VERTICES;

		ArrayList<Node> result = new ArrayList<>();

		for (Node edge : edges) {
			char v1Root = getRoot(mVerticesRoot, edge.v1);
			char v2Root = getRoot(mVerticesRoot, edge.v2);
			if (v1Root != v2Root) {
				result.add(edge);
				updateRoot(mVerticesRoot, edge.v1, edge.v2);
			}
		}

		result.forEach(node -> System.out.print(node.weight + "\t"));
	}

	/**
	 * @param vertices 顶点数组
	 * @param c        要获取源信息的顶点
	 * @return root 顶点
	 */
	public static Character getRoot(char[] vertices, char c) {
		return vertices[c - 'A'];
	}

	/**
	 * 更新root信息的时候，更新所有以该点为root的所有顶点
	 *
	 * @param vertices root数组
	 * @param c1       顶点c1
	 * @param c2       顶点c2
	 */
	public static void updateRoot(char[] vertices, char c1, char c2) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i] == vertices[c2 - 'A'] && i != (c2 - 'A')) {
				vertices[i] = vertices[c1 - 'A'];
			}
		}
		vertices[c2 - 'A'] = vertices[c1 - 'A'];
	}

	public static void sortEdgesByWeight(Node[] edges) {
		quickSort(edges, 0, edges.length - 1);
	}

	public static void printKruskalWeight(Node[] edges) {
		for (Node edge : edges) {
			System.out.println(edge.v1 + "->" + edge.v2 + "\t" + edge.weight);
		}
	}

	private static void quickSort(Node[] edges, int left, int right) {
		if (left < right) {
			int tempLeft = left;
			int tempRight = right;
			Node tempLeftNode = edges[tempLeft];
			while (tempLeft < tempRight) {
				//right to left find one small than tempLeftValue
				while (tempLeft < tempRight && edges[tempRight].compareTo(tempLeftNode) > 0) {
					tempRight--;
				}
				//find index which value low than tempLeftValue
				if (tempLeft < tempRight) {
					edges[tempLeft++] = edges[tempRight];
				}
				//left to right find one big than tempLeftValue
				while (tempLeft < tempRight && edges[tempLeft].compareTo(tempLeftNode) < 0) {
					tempLeft++;
				}
				//find index which value big than tempLeftValue
				if (tempLeft < tempRight) {
					edges[tempRight] = edges[tempLeft];
				}
			}
			//while loop over means tempLeft >= tempRight
			edges[tempLeft] = tempLeftNode;
			quickSort(edges, left, tempLeft - 1);
			quickSort(edges, tempLeft + 1, right);
		}
	}

}
