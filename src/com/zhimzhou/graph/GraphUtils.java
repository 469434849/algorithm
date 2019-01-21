package com.zhimzhou.graph;

import java.util.Scanner;

/**
 * 图相关数据的初始化，输出
 *
 * @author zhimzhou
 * @date 2019/1/21 11:09
 **/
public class GraphUtils {
	private static Scanner scanner = new Scanner(System.in);
	private static final int INF = Integer.MAX_VALUE;
	private static final char[] VERTICES = new char[]{
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'
	};

	private GraphUtils() {
	}

	/**
	 * 无向图的邻接矩阵
	 *
	 * @return
	 */
	public static int[][] udgMatrix() {
		System.out.println("请输入顶点个数:");
		int mVertices = scanner.nextInt();
		System.out.println("请输入边数目:");
		int mEdges = scanner.nextInt();
		int[][] result = new int[mVertices][mVertices];
		for (int i = 0; i < mEdges; i++) {
			System.out.println("输入第" + (i + 1) + "条边的起点:");
			char c1 = scanner.next().charAt(0);
			System.out.println("输入第" + (i + 1) + "条边的终点:");
			char c2 = scanner.next().charAt(0);
			System.out.println("请输入边的大小:");
			int value = scanner.nextInt();
			result[c1 - 'A'][c2 - 'A'] = value;
			result[c2 - 'A'][c1 - 'A'] = value;
		}
		for (int i = 0; i < mVertices; i++) {
			for (int j = 0; j < mVertices; j++) {
				if (result[i][j] == 0 && i != j) {
					result[i][j] = INF;
				}
			}
		}
		return result;
	}

	public static void printUdgMatrix(int[][] matrix) {
		System.out.print("\t");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(VERTICES[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(VERTICES[i] + "\t");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] == INF ? "-\t" : matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
