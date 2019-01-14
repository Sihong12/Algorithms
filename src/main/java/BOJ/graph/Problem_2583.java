package BOJ.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 영역 구하기 (https://www.acmicpc.net/problem/2583)
 */
public class Problem_2583 {

	private static final int[] xDirection = {-1, 0, 1, 0};
	private static final int[] yDirection = {0, -1, 0, 1};
	private static final int EMPTY_AREA = 0;

	private static int[][] paper;
	private static boolean[][] visited;
	private static List<Integer> areaSizes = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int m = scanner.nextInt();
		int n = scanner.nextInt();
		paper = new int[n][m];

		int k = scanner.nextInt();
		for (int i = 0; i < k; i++) {
			paintArea(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		}

		visited = new boolean[n][m];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if (paper[i][j] == EMPTY_AREA && !visited[i][j]) {
					areaSizes.add(DFS(i, j, 0));
//					areaSizes.add(BFS(i, j));
				}
			}
		}
		Collections.sort(areaSizes);
		System.out.println(areaSizes.size());
		for (Integer areaSize : areaSizes) {
			System.out.println(areaSize);
		}
	}

	private static void paintArea(int leftX, int leftY, int rightX, int rightY) {
		for (int i = leftX; i < rightX; i++) {
			for (int j = leftY; j < rightY; j++) {
				paper[i][j] = 1;
			}
		}
	}

	private static int DFS(int x, int y, int areaSize) {
		visited[x][y] = true;
		++areaSize;

		for (int i = 0; i < 4; i++) {
			int nextX = x + xDirection[i];
			int nextY = y + yDirection[i];

			if (nextX < 0 || nextY < 0 || nextX >= paper.length || nextY >= paper[0].length) continue;
			if (paper[nextX][nextY] != EMPTY_AREA || visited[nextX][nextY]) continue;

			areaSize = DFS(nextX, nextY, areaSize);
		}
		return areaSize;
	}

	private static int BFS(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;

		int areaSize = 1;
		while (!queue.isEmpty()) {
			Point point = queue.remove();
			for (int i = 0; i < 4; i++) {
				int nextX = point.x + xDirection[i];
				int nextY = point.y + yDirection[i];

				if (nextX < 0 || nextY < 0 || nextX >= paper.length || nextY >= paper[0].length) continue;
				if (paper[nextX][nextY] != EMPTY_AREA || visited[nextX][nextY]) continue;

				queue.add(new Point(nextX, nextY));
				visited[nextX][nextY] = true;
				++areaSize;
			}
		}
		return areaSize;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
