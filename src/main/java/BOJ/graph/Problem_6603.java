package BOJ.graph;

import java.util.Scanner;
import java.util.StringJoiner;

public class Problem_6603 {

	private static final int MAX_PICK_COUNT = 6;
	private static boolean[] isVisited;
	private static int[] numbers;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int k;
		while ((k = scanner.nextInt()) != 0){
			numbers = new int[k + 1];
			isVisited = new boolean[k + 1];
			for (int i = 1; i <= k; i++) {
				numbers[i] = scanner.nextInt();
			}

			DFS(1, 0);
			System.out.println();
		}
	}

	private static void DFS(int index, int count) {
		if (count == MAX_PICK_COUNT) {
			System.out.println(makeLotto());
			return;
		}
		if (index >= numbers.length) return;

		isVisited[index] = true;
		DFS(index + 1, count + 1);
		isVisited[index] = false;
		DFS(index + 1, count);
	}

	private static String makeLotto() {
		StringJoiner joiner = new StringJoiner(" ");
		for (int i = 1; i < isVisited.length; i++) {
			if (isVisited[i]) joiner.add(Integer.toString(numbers[i]));
		}
		return joiner.toString();
	}
}
