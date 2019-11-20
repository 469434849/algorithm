package main.java.com.zhimzhou.sort;

/**
 * 最好时间复杂度		最坏时间复杂度		平均时间复杂度		空间复杂度	稳定性
 * 传统归并排序	O(nlogn)		O(nlogn)		O(nlogn)		T(n)		稳定
 * TimSort  	O(n)			O(nlogn)		O(nlogn)		T(n)		稳定
 * <p>
 * 归并排序的时间复杂度是O(N*logN)。
 * 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？
 * 归并排序的形式就是一棵二叉树，它需要遍历的次数就是二叉树的深度，而根据完全二叉树的可以得出它的时间复杂度是O(N*logN)。
 */


/**
 * 归并排序
 *
 * @author main.java.zhimzhou
 * @date 2018/12/29 15:01
 **/
public class MergeSort {

	public static void main(String[] args) {
		int[] array = new int[]{
				10, 18, 4, 3, 6, 12, 1, 9, 15, 8
		};
		sort(array);
	}

	private static void sort(int[] arr) {
		System.out.println("由上往下合并:");
		sortByUp2Down(arr, 0, arr.length - 1);
		System.out.println("由下往上合并:");
		sortByDown2up(arr, arr.length);
	}

	/**
	 * 将两个有序的子序列合并
	 */
	private static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[arr.length];
		int i = left;
		int j = mid + 1;
		int t = 0;
		if (arr[mid] > arr[j]) {
			while (i <= mid && j <= right) {
				if (arr[i] <= arr[j]) {
					temp[t++] = arr[i++];
				} else {
					temp[t++] = arr[j++];
				}
			}
		}

		//将左边剩余元素填充进temp中
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		//将右序列剩余元素填充进temp中
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		t = 0;
		//将temp中的元素全部拷贝到原数组中
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}

	/**
	 * up2down 由上往下，先分在合
	 */
	private static void sortByUp2Down(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			//左边归并排序，使得左子序列有序
			sortByUp2Down(arr, left, mid);
			//右边归并排序，使得右子序列有序
			sortByUp2Down(arr, mid + 1, right);
			//将两个有序子数组合并操作
			merge(arr, left, mid, right);
		}
		PrintUtil.printArray(arr);
	}

	/**
	 * down2up 由下往上
	 */
	private static void sortByDown2up(int[] arr, int length) {
		//gap的变化必须是成倍数的变化
		for (int gap = 1; gap < length; gap *= 2) {
			down2up(arr, length, gap);
			PrintUtil.printArray(arr);
		}
	}

	/**
	 * @param array 待排序数组
	 * @param len   数组长度
	 * @param gap   子数组长度
	 */
	private static void down2up(int[] array, int len, int gap) {

		int i;
		//将相邻的子数组进行排序，子数组长度为gap
		for (i = 0; i + 2 * gap - 1 < len; i += (2 * gap)) {
			//i==left i+gap-1 == mid    i+2*gap-1 == right
			merge(array, i, i + gap - 1, i + 2 * gap - 1);
		}

		// i== 0的时候整个和多余部分排序，最后一次排序，核心
		if (i + gap - 1 < len - 1) {
			merge(array, i, i + gap - 1, len - 1);
		}

	}
}

/**
 * up2down
 * <p>
 * 10	18	4	3	6	12	1	9	15	8
 * 10	18	4	3	6	12	1	9	15	8
 * 10	18	4	3	6	12	1	9	15	8
 * 10	18	4	3	6	12	1	9	15	8
 * 4	10	18	3	6	12	1	9	15	8
 * 4	10	18	3	6	12	1	9	15	8
 * 4	10	18	3	6	12	1	9	15	8
 * 4	10	18	3	6	12	1	9	15	8
 * 3	4	6	10	18	12	1	9	15	8
 * 3	4	6	10	18	12	1	9	15	8
 * 3	4	6	10	18	12	1	9	15	8
 * 3	4	6	10	18	1	12	9	15	8
 * 3	4	6	10	18	1	12	9	15	8
 * 3	4	6	10	18	1	9	12	15	8
 * 3	4	6	10	18	1	9	12	15	8
 * 3	4	6	10	18	1	9	12	15	8
 * 3	4	6	10	18	1	9	12	8	15
 * 3	4	6	10	18	1	8	9	12	15
 * 1	3	4	6	8	9	10	12	15	18
 * <p>
 * down2up
 * <p>
 * 10	18	3	4	6	12	1	9	8	15
 * 3	4	10	18	1	6	9	12	8	15
 * 1	3	4	6	9	10	12	18	8	15
 * 1	3	4	6	8	9	10	12	15	18
 */

