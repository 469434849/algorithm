package com.zhimzhou.sort;

/**
 * 选择排序
 * 基本思想：首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 * 时间复杂度：O(N2)
 * 选择排序稳定性：不稳定
 * 选择排序是给每个位置选择当前元素最小的，比如给第一个位置选择最小的，
 * 在剩余元素里面给第二个元素选择第二小的，依次类推，直到第n-1个元素，第n个元素不用选择了，
 * 因为只剩下它一个最大的元素了。那么，在一趟选择，如果一个元素比当前元素小，
 * 而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
 * 比较拗口，举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，
 * 那么原序列中两个5的相对前后顺序就被破坏了，所以选择排序是一个不稳定的排序算法
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
