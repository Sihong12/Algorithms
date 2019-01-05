package BOJ.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 수 찾기 (https://www.acmicpc.net/problem/1920)
 */
public class Problem_1920 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] numbers = inputArray(scanner);
		int[] targets = inputArray(scanner);

		int[] exists = existNumber(numbers, targets);
		for (int exist : exists) {
			System.out.println(exist);
		}
	}

	private static int[] inputArray(Scanner scanner) {
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = scanner.nextInt();
		}
		return numbers;
	}

	public static int[] existNumber(int[] numbers, int[] targets) {
		Arrays.sort(numbers);

		int[] exists = new int[targets.length];
		for (int index = 0; index < targets.length; index++) {
			int target = targets[index];
			exists[index] = binarySearch(numbers, target);
		}
		return exists;
	}

	private static int binarySearch(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (numbers[mid] < target) {
				start = mid + 1;
			} else if (numbers[mid] > target) {
				end = mid - 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
