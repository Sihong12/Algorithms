package BOJ.output;

import java.util.Scanner;

/**
 * 별 찍기 - 4 (https://www.acmicpc.net/problem/2441)
 *
 * 오른쪽 정렬된 별 출력
 */
public class Problem_2441 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < row; col++) {
				System.out.print(" ");
			}
			for (int col = row; col < n; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
