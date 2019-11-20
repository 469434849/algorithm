package main.java.com.zhimzhou.sort;

/**
 * 插入排序  O(n^2) 稳定排序
 *
 * @author main.java.zhimzhou
 * @date 2018/12/28 19:19
 **/
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = new int[]{
				10, 9, 8, 7, 6, 5, 2, 4, 1, 3
		};
		insertSort(arr, arr.length);
	}

	private static void insertSort(int[] array, int length) {
		PrintUtil.printArray(array);
		for (int i = 1; i < length; i++) {
			int temp = array[i];
			int j;
			for (j = i; j > 0 && temp < array[j - 1]; j--) {
				array[j] = array[j - 1];
			}
			array[j] = temp;
			PrintUtil.printArray(array);
		}

	}


}

/**
 * 从第二个元素开始遍历，与之前元素比较，插入到合适位置（找到比当前元素小的元素之后）
 * <p>
 * 10	9	8	7	6	5	2	4	1	3
 * 9	10	8	7	6	5	2	4	1	3
 * 8	9	10	7	6	5	2	4	1	3
 * 7	8	9	10	6	5	2	4	1	3
 * 6	7	8	9	10	5	2	4	1	3
 * 5	6	7	8	9	10	2	4	1	3
 * 2	5	6	7	8	9	10	4	1	3
 * 2	4	5	6	7	8	9	10	1	3
 * 1	2	4	5	6	7	8	9	10	3
 * 1	2	3	4	5	6	7	8	9	10
 */
