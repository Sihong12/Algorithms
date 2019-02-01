package utils;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{1,9,2,8,3,7,6,4,5};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		int pivot = arr[(left + right) / 2];

		while (left <= right) {
			while (arr[left] < pivot) left++;
			while (arr[right] > pivot) right--;
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		if (start < right) sort(arr, start, right);
		if (end > left) sort(arr, left, end);
	}
}
