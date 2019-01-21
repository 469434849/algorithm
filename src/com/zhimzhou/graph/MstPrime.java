package com.zhimzhou.graph;

import java.util.ArrayList;

/**
 * MST minimum spanning tree 邻接矩阵实现
 * Prime算法基本思想:
 * 对于图G而言，V是所有顶点的集合；现在，设置两个新的集合U和T，其中U用于存放G的最小生成树中的顶点，T存放G的最小生成树中的边。
 * 从所有uЄU，vЄ(V-U) (U是已经选择的顶点，V-U表示出去U的所有顶点，也就是还未选择)的边中选取权值最小的边(u, v)，
 * 将顶点v加入集合U中，将边(u, v)加入集合T中，如此不断重复，直到U=V（所有顶点均已选择）为止，最小生成树构造完毕，这时集合T中包含了最小生成树中的所有边。
 *
 * @author zhimzhou
 * @date 2019/1/21 10:48
 **/
public class MstPrime {
	private static final int INF = Integer.MAX_VALUE;
	private static final char[] VERTICES = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'
	};

	public static void main(String[] args) {
		int[][] udgMatrix = new int[][]{
				{0, 12, INF, INF, INF, 16, 14,},
				{12, 0, 10, INF, INF, 7, INF,},
				{INF, 10, 0, 3, 5, 6, INF,},
				{INF, INF, 3, 0, 4, INF, INF,},
				{INF, INF, 5, 4, 0, 2, 8,},
				{16, 7, 6, INF, 2, 0, 9,},
				{14, INF, INF, INF, 8, 9, 0,},
		};
		GraphUtils.printUdgMatrix(udgMatrix);
		mst(udgMatrix, 0);
	}

	private static void mst(int[][] udgMatrix, int start) {
		//保存边的结果
		ArrayList<Integer> mEdges = new ArrayList<>();
		int verticesNumber = udgMatrix.length;
		//已选择顶点
		ArrayList<Character> hasChoose = new ArrayList<>();
		hasChoose.add(VERTICES[start]);
		//待选顶点
		ArrayList<Character> notChoose = new ArrayList<>();
		for (int i = 0; i < verticesNumber; i++) {
			if (i != start) {
				notChoose.add(VERTICES[i]);
			}
		}

		while (hasChoose.size() < verticesNumber) {
			addMinimumVertices(udgMatrix, hasChoose, notChoose, mEdges);
		}

		System.out.println("最小生成树的权值:");
		for (Integer mEdge : mEdges) {
			System.out.print(mEdge + "\t");
		}
		System.out.println();
		System.out.println("最小生成树的顶点:");
		for (Character aHasChoose : hasChoose) {
			System.out.print(aHasChoose + "\t");
		}
		System.out.println();
	}

	private static void addMinimumVertices(int[][] udgMatrix, ArrayList<Character> choose, ArrayList<Character> notChoose, ArrayList<Integer> mEdges) {
		int notChooseVerticesCount = notChoose.size();
		int minValue = INF;
		char chooseVertices = notChoose.get(0);
		Boolean flag = false;
		int indexX;
		int indexY;
		for (int i = 0; i < choose.size(); i++) {
			indexX = choose.get(i) - 'A';
			for (int j = 0; j < notChooseVerticesCount; j++) {
				indexY = notChoose.get(j) - 'A';
				if (udgMatrix[indexX][indexY] < minValue) {
					minValue = udgMatrix[indexX][indexY];
					chooseVertices = notChoose.get(j);
					flag = true;
				}
			}
		}
		if (flag) {
			choose.add(chooseVertices);
			notChoose.remove(new Character(chooseVertices));
			mEdges.add(minValue);
		}
	}
}
