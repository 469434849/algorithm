package main.java.com.zhimzhou.sort;

import java.util.Arrays;

/**
 * Arrays.sort()
 * jdk1.7及以前用的是快排
 * jdk1.8开始使用DualPivotQuicksort（双轴快排）
 * <p>
 * 快速排序:分治法策略
 * 基本思想：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
 * 其中一部分的所有数据都比另外一部分的所有数据都要小。
 * 然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * <p>
 * 快速排序流程：
 * (1) 从数列中挑出一个基准值。
 * (2) 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；在这个分区退出之后，该基准就处于数列的中间位置。
 * (3) 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 * <p>
 * 快速排序稳定性:不稳定
 * 快速排序时间复杂度：最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)
 * 假设被排序的数列中有N个数。遍历一次的时间复杂度是O(N)，需要遍历多少次呢？至少lg(N+1)次，最多N次。
 * (01) 为什么最少是lg(N+1)次？快速排序是采用的分治法进行遍历的，我们将它看作一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的定义，它的深度至少是lg(N+1)。因此，快速排序的遍历次数最少是lg(N+1)次。
 * (02) 为什么最多是N次？这个应该非常简单，还是将快速排序看作一棵二叉树，它的深度最大是N。因此，快读排序的遍历次数最多是N次。
 *
 * @author main.java.zhimzhou
 * @date 2019/1/7 11:49
 **/
public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[]{
				10, 18, 4, 3, 6, 12, 1, 9, 15, 8
		};

		int[] array1 = new int[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		quickSort(array1, 0, array1.length - 1);
		PrintUtil.printArray(array1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int tempLeft = left;
			int tempRight = right;
			int tempLeftValue = arr[tempLeft];
			while (tempLeft < tempRight) {
				//right to left find one small than tempLeftValue
				while (tempLeft < tempRight && arr[tempRight] > tempLeftValue) {
					tempRight--;
				}
				//find index which value low than tempLeftValue
				if (tempLeft < tempRight) {
					arr[tempLeft++] = arr[tempRight];
				}
				//left to right find one big than tempLeftValue
				while (tempLeft < tempRight && arr[tempLeft] < tempLeftValue) {
					tempLeft++;
				}
				//find index which value big than tempLeftValue
				if (tempLeft < tempRight) {
					arr[tempRight] = arr[tempLeft];
				}
			}
			//while loop over means tempLeft >= tempRight
			arr[tempLeft] = tempLeftValue;
			quickSort(arr, left, tempLeft - 1);
			quickSort(arr, tempLeft + 1, right);
		}
	}

}
