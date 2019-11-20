package main.java.com.zhimzhou.sort;

/**
 * 堆排序
 * 利用二叉树的思想，堆主要为完全二叉树，分为大根堆和小根堆
 * 利用数组实现：i 节点的左孩子为（2i+1） 右孩子为（2i+2）    i的父节点为（floor(i-1)/2）
 * 时间复杂度是:O(N*lgN)
 * 堆排序稳定性:不稳定（在交换数据的时候，是比较父结点和子节点之间的数据，所以，即便是存在两个数值相等的兄弟节点，它们的相对顺序在排序也可能发生变化）
 * 基本思想：
 * 初始化堆：将数列a[1...n]构造成最大堆。 1...n  == 0...n-1
 * 交换数据：将a[1]和a[n]交换，使a[n]是a[1...n]中的最大值；然后将a[1...n-1]重新调整为最大堆。
 * 接着，将a[1]和a[n-1]交换，使a[n-1]是a[1...n-1]中的最大值；然后将a[1...n-2]重新调整为最大值。
 * 依次类推，直到整个数列都是有序的。
 * (第一次从下往上调,交换之后从上往下调)
 *
 * @author main.java.zhimzhou
 * @date 2019/1/7 15:21
 **/
public class HeapSort {

	public static void main(String[] args) {
		int[] array = new int[]{
				10, 18, 4, 3, 6, 12, 1, 9, 15, 8
		};
		heapSortAsc(array, array.length);
		PrintUtil.printArray(array);
	}

	private static void heapSortAsc(int[] arr, int length) {
		//n>>1-1是第一个非叶子节点
		int lastContainsChildNodeIndex = ((length) >> 1) - 1;
		//Adjust array to arr[0] is the max value
		while (lastContainsChildNodeIndex >= 0) {
			maxHeapUp2Down(arr, lastContainsChildNodeIndex--, length - 1);
		}

		for (int i = length - 1; i > 0; i--) {
			arr[i] = arr[i] ^ arr[0];
			arr[0] = arr[i] ^ arr[0];
			arr[i] = arr[i] ^ arr[0];
			maxHeapUp2Down(arr, 0, i - 1);
		}
	}

	/**
	 * 从数组的start位置开始，调整为大根堆
	 *
	 * @param arr   数组
	 * @param start 为存在子节点的数组索引
	 * @param end   数组最后一个元素索引（length-1）
	 */
	private static void maxHeapUp2Down(int[] arr, int start, int end) {
		int current = start;
		int leftChild = (current << 1) + 1;
		//for (; leftChild <= end; current = leftChild, leftChild = (leftChild << 1) + 1) {
		while (leftChild <= end) {
			int maxChildIndex = leftChild;
			//最后一个含有子节点的节点仅含有一个左孩子
			if (leftChild < end && arr[leftChild] < arr[leftChild + 1]) {
				maxChildIndex = leftChild + 1;
			}
			//swap
			if (arr[current] < arr[maxChildIndex]) {
				arr[current] = arr[current] ^ arr[maxChildIndex];
				arr[maxChildIndex] = arr[current] ^ arr[maxChildIndex];
				arr[current] = arr[current] ^ arr[maxChildIndex];
			}
			current = leftChild;
			leftChild = (leftChild << 1) + 1;
		}
	}

}
