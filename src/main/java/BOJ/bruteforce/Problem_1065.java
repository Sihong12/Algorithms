package BOJ.bruteforce;

import java.util.Scanner;

/**
 * 한수 (https://www.acmicpc.net/problem/1065)
 *
 * 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 * N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 *
 * 1부터 99까진 항상 등차수열을 만족하며, 1000은 등차수열이 아니기 때문에 세자리인 경우만 체크하면 됨
 * 1 <= N <= 1000
 */
public class Problem_1065 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		if (n < 100) {
			System.out.println(n);
		} else {
			System.out.println(99 + count(n));
		}
	}

	private static int count(int n) {
		int count = 0;
		for (int number = 100; number <= n; number++) {
			int hundred = number / 100;
			int ten = number % 100 / 10;
			int unit = number % 100 % 10;
			if(ten + (ten - hundred) == unit){
				++count;
			}
		}
		return count;
	}
}
