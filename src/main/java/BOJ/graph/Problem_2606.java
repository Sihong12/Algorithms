package BOJ.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 바이러스 (https://www.acmicpc.net/problem/2606)
 */
public class Problem_2606 {

	private static boolean[][] connection;
	private static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int computers = scanner.nextInt();
		connection = new boolean[computers + 1][computers + 1];

		int connectionCount = scanner.nextInt();
		for (int i = 0; i < connectionCount; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			connection[from][to] = connection[to][from] = true;
		}
		isVisited = new boolean[connection.length];
		System.out.println(BFS(1));
	}

	private static int BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		isVisited[start] = true;

		int infectionCount = -1;
		while (!queue.isEmpty()) {
			++infectionCount;
			int current = queue.remove();
			for (int next = 1; next < connection.length; next++) {
				if (connection[current][next] && !isVisited[next]) {
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}
		return infectionCount;
	}
}
