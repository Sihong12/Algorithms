package BOJ.string;

import java.util.Scanner;

/**
 * 상수 (https://www.acmicpc.net/problem/2908)
 */
public class Problem_2908 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int first = scanner.nextInt();
		int second = scanner.nextInt();

		System.out.println(Math.max(reverse(first), reverse(second)));
	}

	public static int reverse(int number) {
		int reverseNumber = 0;
		while (number != 0) {
			reverseNumber = reverseNumber * 10 + number % 10;
			number /= 10;
		}
		return reverseNumber;
	}
}
