package com.wclass.structalgorithm.other;

public class d1_SmallSum {

	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]既要排好序，也要求小和返回
	// 所有merge时，产生的小和，累加
	// 左 排序   merge
	// 右 排序  merge
	// merge
	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		// l < r
		int mid = l + ((r - l) >> 1);
		return 
				process(arr, l, mid) 
				+ 
				process(arr, mid + 1, r) 
				+ 
				merge(arr, l, mid, r);
	}

	public static int merge(int[] arr, int L, int m, int r) {
		int[] help = new int[r - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}

}
