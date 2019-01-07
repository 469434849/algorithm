package com.zhimzhou.sort;

/**
 * 选择排序
 * 基本思想：首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 * 时间复杂度：O(N2)
 * 选择排序稳定性：稳定
 *
 * @author zhimzhou
 * @date 2019/1/7 11:17
 **/
public class SelectionSort {
	public static void main(String[] args) {
		int[] array = new int[]{
				10, 18, 4, 3, 6, 12, 1, 9, 15, 8
		};
		selectSort(array, array.length);
		PrintUtil.printArray(array);
	}

	private static void selectSort(int[] arr, int length) {
		if (length > 1) {
			int temp, min, minIndex;
			for (int i = 0; i < length - 1; i++) {
				temp = arr[i];
				min = arr[i];
				minIndex = i;
				for (int j = i; j < length - 1; j++) {
					if (arr[j + 1] < min) {
						minIndex = j + 1;
						min = arr[j + 1];
					}
				}
				arr[i] = min;
				arr[minIndex] = temp;
			}
		}

	}
}
