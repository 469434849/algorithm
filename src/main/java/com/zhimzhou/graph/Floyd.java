package main.java.com.zhimzhou.graph;

/**
 * 多源最短路径问题,算法时间复杂度是O(n3)
 *
 * for (int k = 0; k < length; k++)
 * 		for (int i = 0; i < length; i++)
 * 			for (int j = 0; j < length; j++)
 * 				matrix[i][j] = min(matrix[i][k]+matrix[k][j], matrix[i][j]);
 *
 *
 *
 * @author main.java.zhimzhou
 * @date 2019/1/25 17:16
 **/
public class Floyd {
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
		floydMinimumPath(udgMatrix);

	}

	public static void floydMinimumPath(int[][] matrix) {
		int length = matrix.length;
		for (int k = 0; k < length; k++) {
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					matrix[i][j] = min(matrix[i][k], matrix[k][j], matrix[i][j]);
				}
			}
		}
		printUdgMatrix(matrix);
	}

	public static int min(int i11, int i12, int i2) {
		int i1 = INF;
		if (i11 != INF && i12 != INF) {
			i1 = i11 + i12;
		}
		return i1 > i2 ? i2 : i1;
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
		System.out.println();

	}
}
