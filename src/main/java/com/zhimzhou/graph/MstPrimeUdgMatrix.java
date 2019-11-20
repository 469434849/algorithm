package main.java.com.zhimzhou.graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MST minimum spanning tree 邻接矩阵实现
 * Prime算法基本思想:
 * 对于图G而言，V是所有顶点的集合；现在，设置两个新的集合U和T，其中U用于存放G的最小生成树中的顶点，T存放G的最小生成树中的边。
 * 从所有uЄU，vЄ(V-U) (U是已经选择的顶点，V-U表示出去U的所有顶点，也就是还未选择)的边中选取权值最小的边(u, v)，
 * 将顶点v加入集合U中，将边(u, v)加入集合T中，如此不断重复，直到U=V（所有顶点均已选择）为止，最小生成树构造完毕，这时集合T中包含了最小生成树中的所有边。
 * <p>
 * 时间复杂度: V个顶点 E 条边 O（E*lgV）
 *
 * @author main.java.zhimzhou
 * @date 2019/1/21 10:48
 **/
public class MstPrimeUdgMatrix {
	private static Scanner scanner = new Scanner(System.in);
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
		printUdgMatrix(udgMatrix);
		mst(udgMatrix, 0);
		//最小生成树的权值:
		//12	7	2	4	3	8
		//最小生成树的顶点:
		//A	B	F	E	D	C	G
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
		int minValue = INF;
		char chooseVertices = notChoose.get(0);
		Boolean flag = false;
		int indexX;
		int indexY;
		for (Character aChoose : choose) {
			indexX = aChoose - 'A';
			for (Character aNotChoose : notChoose) {
				indexY = aNotChoose - 'A';
				if (udgMatrix[indexX][indexY] < minValue) {
					minValue = udgMatrix[indexX][indexY];
					chooseVertices = aNotChoose;
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

	/**
	 * 无向图的邻接矩阵
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
