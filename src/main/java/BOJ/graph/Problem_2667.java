package BOJ.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 단지번호붙이기 (https://www.acmicpc.net/problem/2667)
 */
public class Problem_2667 {

	private static int[][] map;
	private static boolean[][] visited;
	private static List<Integer> regionSizes = new ArrayList<>();
	private static int[] rowDirection = {0, -1, 0, 1};
	private static int[] colDirection = {-1, 0, 1, 0};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = scanner.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (map[row][col] == 1 && !visited[row][col]) {
					regionSizes.add(calculateRegionSize(row, col, 0));
				}
			}
		}

		System.out.println(regionSizes.size());
		Collections.sort(regionSizes);
		for (Integer regionSize : regionSizes) {
			System.out.println(regionSize);
		}
	}

	private static int calculateRegionSize(int row, int col, int regionSize) {
		++regionSize;
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nextRow = row + rowDirection[i];
			int nextCol = col + colDirection[i];

			if (nextRow < 0 || nextCol < 0 || nextRow >= map.length || nextCol >= map.length) continue;
			if (map[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) continue;

			regionSize = calculateRegionSize(nextRow, nextCol, regionSize);
		}
		return regionSize;
	}
}
