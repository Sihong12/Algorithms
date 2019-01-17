package BOJ.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 조세퍼스 문제 0 (https://www.acmicpc.net/problem/11866)
 */
public class Problem_11866 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		int m = scanner.nextInt() - 1;
		int index = 0;
		StringJoiner output = new StringJoiner(", ", "<", ">");
		while (!list.isEmpty()) {
			index += m;
			if (index >= list.size()) {
				index %= list.size();
			}
			output.add(list.remove(index).toString());
		}
		System.out.println(output.toString());
	}
}
