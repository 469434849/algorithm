package com.zhimzhou.sort;

import java.util.Random;

/**
 * 基数排序
 * 基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。个位，十位，百位，千位...
 * 1.按着个位开始，放入10个桶中，顺序取出，保存为新的数组
 * 2.将新数组，按十位大小顺序放入是个桶中，顺序取出，保存为新数组
 * 如此循环，知道最大数值的最高为排序完成
 * <p>
 * 稳定性：稳定与不稳定与写法有关，本demo，不稳定
 * 最大值的位数N,数据个数M
 * 时间复杂度： 则：O（N * M + M）= O(N * M)
 * 空间复杂度为：O（10 × M）= O （M）
 *
 * @author zhimzhou
 * @date 2019/1/17 17:49
 **/
public class RadixSort {
	public static void main(String[] args) {
		int[] array = initArray(10);
		PrintUtil.printArray(array);
		int max = getMaxValue(array);
		System.out.println(max);
		PrintUtil.printArray(sortArray(array));
	}

	private static int[] initArray(int count) {
		Random random = new Random();
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = random.nextInt(10000);
		}
		return array;
	}

	private static int getMaxValue(int[] array) {
		int max = 0;
		for (int anArray : array) {
			max = anArray > max ? anArray : max;
		}
		return max;
	}

	private static int[] sortArray(int[] sourceArray) {
		int maxValue = getMaxValue(sourceArray);
		int exp = 1;
		while (maxValue / exp > 0) {
			sortByExp(sourceArray, exp);
			exp *= 10;
		}
		return sourceArray;
	}

	/**
	 * @param array 排序数组
	 * @param exp   排序筛选位数，个位 1 ，十位 10，百位 100  ....
	 */
	private static void sortByExp(int[] array, int exp) {
		int[] bucket = new int[10];
		//计算exp 位的数据个数，存在bucket中
		for (int anArray : array) {
			bucket[(anArray / exp) % 10]++;
		}
		PrintUtil.printArray(bucket);

		// 更改bucket[i]。目的是让更改后的buckets[i]的值，是该数据在temp[]中的位置。index+1
		for (int i = 1; i < 10; i++) {
			bucket[i] += bucket[i - 1];
		}

		PrintUtil.printArray(bucket);

		int[] temp = new int[array.length];
		for (int anArray : array) {
			temp[bucket[(anArray / exp) % 10] - 1] = anArray;
			bucket[(anArray / exp) % 10]--;
			PrintUtil.printArray(temp);
		}

		System.arraycopy(temp, 0, array, 0, array.length);

	}
}
