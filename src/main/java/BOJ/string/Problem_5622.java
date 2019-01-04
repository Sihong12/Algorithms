package BOJ.string;

import java.util.Scanner;

/**
 * 다이얼 (https://www.acmicpc.net/problem/5622)
 */
public class Problem_5622 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		System.out.println(calculateTime(word));
	}

	public static int calculateTime(String word) {
		int[] numbers = new int[]{2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		int time = 0;
		for (char character : word.toCharArray()) {
			time += numbers[character - 'A'] + 1;
		}
		return time;
	}
}
