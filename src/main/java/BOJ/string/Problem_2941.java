package BOJ.string;

import java.util.Scanner;

/**
 * 크로아티아 알파벳 (https://www.acmicpc.net/problem/2941)
 */
public class Problem_2941 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		System.out.println(count(word));
	}

	public static int count(String word) {
		int count = 0;
		String[] specialAlphabet = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		for (int index = 0; index < word.length(); index++) {
			++count;
			if (index + 1 == word.length()) break;

			if ((word.charAt(index + 1) == '='
					&& (word.charAt(index) == 'c' || word.charAt(index) == 's' || word.charAt(index) == 'z'))
				|| (word.charAt(index + 1) == '-'
						&& (word.charAt(index) == 'c' || word.charAt(index) == 'd'))
				|| (word.charAt(index + 1) == 'j'
							&& (word.charAt(index) == 'l' || word.charAt(index) == 'n'))) {
				++index;
			} else if (index + 2 < word.length() && word.substring(index, index + 3).equals("dz=")) {
				index += 2;
			}
		}
		return count;
	}
}
