package BOJ.string;

import java.util.Scanner;

/**
 * 단어 공부 (https://www.acmicpc.net/problem/1157)
 */

public class Problem_1157 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] alphabetCount = new int[26];
		for (char alphabet : scanner.nextLine().toLowerCase().toCharArray()) {
			alphabetCount[alphabet - 97]++;
		}

		int maxCount = 0;
		int alphabetIndex = 0;
		boolean isDuplicated = false;
		for (int i = 0; i < alphabetCount.length; i++) {
			if (alphabetCount[i] > maxCount) {
				alphabetIndex = i;
				maxCount = alphabetCount[i];
				isDuplicated = false;
			} else if (alphabetCount[i] == maxCount) {
				isDuplicated = true;
			}
		}

		if (isDuplicated) {
			System.out.println("?");
		} else {
			System.out.println((char) (alphabetIndex + 65));
		}
	}
}
