package BOJ.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 알파벳 찾기 (https://www.acmicpc.net/problem/10809)
 */
public class Problem_10809 {

	public static void main(String[] args) {
		String word = new Scanner(System.in).next();
		int[] alphabet = solve(word);
		for (int index : alphabet) {
			System.out.println(index);
		}
	}

	public static int[] solve(String word) {
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);

		for (int index = 0; index < word.length(); index++) {
			int alphabetIndex = word.charAt(index) - 'a';
			if (alphabet[alphabetIndex] == -1) {
				alphabet[alphabetIndex] = index;
			}
		}
		return alphabet;
	}
}
