package main.java.com.zhimzhou.sort;

/**
 * 冒泡排序
 * 交换两个数值 x = 5 y = 10  x=x^y(x=15)  y=x^y(y=5) x=x^y(x=10) --> x=10 y=5
 *
 * @author main.java.zhimzhou
 * @date 2019/1/2 16:11
 **/
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 10
		};
		sort(arr);
	}

	private static void sort(int[] array) {
		int length = array.length;
		if (length <= 1) {
			return;
		}
		for (int i = length - 1; i > 0; i--) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
//					int temp = array[j];
//					array[j] = array[j + 1];
//					array[j + 1] = temp;
					array[j] = array[j] ^ array[j + 1];
					array[j + 1] = array[j] ^ array[j + 1];
					array[j] = array[j] ^ array[j + 1];
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
			PrintUtil.printArray(array);
		}

	}
}
