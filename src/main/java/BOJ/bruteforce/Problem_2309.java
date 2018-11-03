package BOJ.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 일곱 난쟁이 (https://www.acmicpc.net/problem/2309)
 */
public class Problem_2309 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int MAX_DWARF_COUNT = 9;
		int[] height = new int[MAX_DWARF_COUNT];
		int totalHeight = 0;
		for (int i = 0; i < MAX_DWARF_COUNT; i++) {
			height[i] = scanner.nextInt();
			totalHeight += height[i];
		}

		loop1:
		for (int i = 0; i < MAX_DWARF_COUNT - 1; i++) {
			for (int j = i + 1; j < MAX_DWARF_COUNT; j++) {
				if ((totalHeight - (height[i] + height[j])) == 100) {
					height[i] = -1;
					height[j] = -1;
					break loop1;
				}
			}

		}

		Arrays.sort(height);
		for (int i = 2; i < MAX_DWARF_COUNT; i++) {
			System.out.println(height[i]);
		}
	}

}
