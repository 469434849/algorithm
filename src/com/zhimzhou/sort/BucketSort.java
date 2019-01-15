package com.zhimzhou.sort;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
/**
 * 桶排序----常用于数据量比较大且集中分布的情况
 * 时间复杂度：
 * N个待排序数字，M个桶,数据平均分布每个桶（N/M个元素），假设桶内排序时间复杂度为O(N*logN),
 * 则O(N)+O(M*(N/M)*log(N/M))=O(N+N*(logN-logM))=O(N+N*logN-N*logM)
 * 空间复杂度：
 * O(N+M)
 * 稳定性：稳定
 * <p>
 * 一般桶的个数为:M = max-min+1
 * 1.如:学生10000000000人，分数分布为0-100  则分配:101个桶（每个桶数据相同）
 * 2.数据100000，分布1-1000，桶分配个数（10，20，50都可以，主要让每个桶的数据不同，进行桶内排序），
 * 为了数据均匀分布可计算出每个桶存的数据范围，scope=(maxValue-minValue)/桶的数目，第一个桶范围:minValue+scope...
 * 3.基于字节的桶排序（根据bit分桶）
 * 4.可用于海量数据的计数
 *
 * @author zhimzhou
 * @date 2019/1/7 18:09
 **/
public class BucketSort {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int count = 100000;
		double[] doubles = initArray(count, 100);
		System.out.println("初始化:" + count + "个数据:" + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println(iSortedArray(doubles));
		long sortStartTime = System.currentTimeMillis();
		sort(doubles, 101);
		System.out.println("桶排序:" + count + "个数据:" + (System.currentTimeMillis() - sortStartTime) + "ms");
		System.out.println(iSortedArray(doubles));
	}

	/**
	 * @param count   初始化排序数据个数
	 * @param dataMax 数据最大值（100）
	 * @return 初始化数据
	 */
	private static double[] initArray(int count, int dataMax) {
		Random random = new Random();
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		double[] array = new double[count];
		for (int i = 0; i < count; i++) {
			array[i] = random.nextDouble() * dataMax;
			array[i] = Double.parseDouble(decimalFormat.format(array[i]));
		}
		return array;
	}

	private static void sort(double[] array, int bucketCount) {
		LinkedList<LinkedList<Double>> linkedLists = new LinkedList<>();
		for (int i = 0; i < bucketCount; i++) {
			linkedLists.add(new LinkedList<>());
		}
		LinkedList<Double> bucket;
		for (double d : array) {
			int floor = (int) Math.floor(d);
			bucket = linkedLists.get(floor);
			if (bucket == null) {
				bucket = new LinkedList<>();
			}
			bucket.addLast(d);
			//桶内排序
			bucketInnerBinarySort(bucket);
			linkedLists.set(floor, bucket);
		}
		Iterator<LinkedList<Double>> iterator = linkedLists.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			LinkedList<Double> next = iterator.next();
			for (Double aNext : next) {
				array[i++] = aNext;
			}
		}
	}

	/**
	 * 桶内部使用二分插入排序 除了新加入的其他已经有序
	 *
	 * @param innerBucket
	 */
	private static void bucketInnerBinarySort(LinkedList<Double> innerBucket) {
		Double last = innerBucket.peekLast();
		if (last == null) {
			return;
		}
		//最后一个不算
		int size = innerBucket.size() - 1;
		int left = 0;
		int right = size - 1;
		int mid = (left + right) >> 1;
		while (left < right) {
			if (innerBucket.get(mid) < last) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left + right) >> 1;
		}
		if (innerBucket.get(left) > last) {
			innerBucket.add(left, last);
		} else {
			innerBucket.add(left + 1, last);
		}
		innerBucket.removeLast();

	}

	/**
	 * 检测数组是否有序
	 */
	private static Boolean iSortedArray(double[] array) {
		int i;
		for (i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return i == array.length - 1;
	}


}
