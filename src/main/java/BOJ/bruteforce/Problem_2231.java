package BOJ.bruteforce;

import java.util.Scanner;

/**
 * 분해합 (https://www.acmicpc.net/problem/2231)
 */
public class Problem_2231 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int output = 0;
		for (int i = 1; i < n; i++) {
			if(n == getSumOfPlace(i)) {
				output = i;
				break;
			}
		}
		System.out.println(output);
	}

	public static final int getSumOfPlace(int num) {
		int sum = num;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
