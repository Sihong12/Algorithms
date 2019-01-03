package BOJ.string;

import java.util.Scanner;

/**
 * 문자열 반복 (https://www.acmicpc.net/problem/2675)
 */
public class Problem_2675 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			int r = Integer.parseInt(scanner.next());
			String word = scanner.next();
			System.out.println(repeat(r, word));
		}
	}

	public static String repeat(int r, String word) {
		StringBuilder result = new StringBuilder();
		for (char character : word.toCharArray()) {
			for (int i = 0; i < r; i++) {
				result.append(character);
			}
		}
		return result.toString();
	}
}
