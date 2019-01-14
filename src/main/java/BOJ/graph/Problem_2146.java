package BOJ.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 다리 만들기 (https://www.acmicpc.net/problem/2146)
 */
public class Problem_2146 {

	private static final int SEA = 0;
	private static final int NOT_BRIDGE = 1000;
	private static final int[] rowDirection = {-1, 0, 1, 0};
	private static final int[] colDirection = {0, -1, 0, 1};

	private static int[][] map;
	private static boolean[][] visited;
	private static List<List<Coast>> coastByCountry = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		int country = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (map[row][col] != SEA && !visited[row][col]) {
					coastByCountry.add(divideCountry(row, col, ++country, new ArrayList<>()));
				}
			}
		}

		int minBridgeSize = NOT_BRIDGE;
		for (List<Coast> coasts : coastByCountry) {
			for (Coast coast : coasts) {
				minBridgeSize = Math.min(minBridgeSize, calculateBridgeSize(coast));
			}
		}
		System.out.println(minBridgeSize);
	}

	private static int calculateBridgeSize(Coast start) {
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], false);
		}

		Queue<Coast> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start.row][start.col] = true;

		int bridgeSize = 0;
		while (!queue.isEmpty()) {
			for (int k = 0; k < map.length; k++) {
				for (int p = 0; p < map.length; p++) {
					System.out.print((visited[k][p])? 1:0);
				}
				System.out.println();
			}
			System.out.println();
			int currentSize = queue.size();
			for (int i = 0; i < currentSize; i++) {
				Coast coast = queue.remove();
				if (map[coast.row][coast.col] != SEA && map[coast.row][coast.col] != start.country) {
					return bridgeSize - 1;
				}

				for (int j = 0; j < 4; j++) {
					int nextRow = coast.row + rowDirection[j];
					int nextCol = coast.col + colDirection[j];

					if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map.length) continue;
					if (visited[nextRow][nextCol]) continue;
					if (map[nextRow][nextCol] != SEA && map[nextRow][nextCol] == coast.country) continue;

					queue.add(new Coast(nextRow, nextCol, coast.country));
					visited[nextRow][nextCol] = true;
				}
			}
			++bridgeSize;
		}
		return NOT_BRIDGE;
	}

	private static List<Coast> divideCountry(int row, int col, int country, List<Coast> coasts) {
		map[row][col] = country;
		visited[row][col] = true;

		boolean isCoast = true;
		for (int i = 0; i < 4; i++) {

			int nextRow = row + rowDirection[i];
			int nextCol = col + colDirection[i];

			if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map.length) continue;
			if (visited[nextRow][nextCol]) continue;
			if (map[nextRow][nextCol] == SEA) {
				isCoast = true;
				continue;
			}

			divideCountry(nextRow, nextCol, country, coasts);
		}

		if (isCoast) {
			coasts.add(new Coast(row, col, country));
		}
		return coasts;
	}
}

class Coast {
	int row;
	int col;
	int country;

	public Coast(int row, int col, int country) {
		this.row = row;
		this.col = col;
		this.country = country;
	}
}
