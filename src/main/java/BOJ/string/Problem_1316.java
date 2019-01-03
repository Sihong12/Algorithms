package BOJ.string;

import java.util.Scanner;

/**
 * 그룹 단어 체커 (https://www.acmicpc.net/problem/1316)
 */
public class Problem_1316 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			String word = scanner.next();
			count += check(word);
		}
		System.out.println(count);
	}

	public static int check(String word) {
		boolean[] checked = new boolean[26];
		int beforeAlphabetIndex = -1;
		for (char character : word.toCharArray()) {
			int alphabetIndex = character - 'a';
			if (beforeAlphabetIndex != alphabetIndex && checked[alphabetIndex]) {
				return 0;
			}
			checked[alphabetIndex] = true;
			beforeAlphabetIndex = alphabetIndex;
		}
		return 1;
	}
}
