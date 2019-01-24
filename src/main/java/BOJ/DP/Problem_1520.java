package BOJ.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 내리막 길 (https://www.acmicpc.net/problem/1520)
 */
public class Problem_1520 {

	private static final int[] rowDirection = {-1, 0, 1, 0};
	private static final int[] colDirection = {0, -1, 0, 1};
	private static int[][] map;
	private static int[][] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		map = new int[m][n];
		visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			Arrays.fill(visited[i], -1);
			for (int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		System.out.println(search(m - 1, n - 1, 0, 0));
	}

	private static int search(int lastRow, int lastCol, int row, int col) {
		if (lastRow == row && lastCol == col) return 1;
		if (visited[row][col] != -1) return visited[row][col];

		visited[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			int nextRow = row + rowDirection[i];
			int nextCol = col + colDirection[i];
			if (nextRow < 0 || nextCol < 0 || nextRow > lastRow || nextCol > lastCol) continue;
			if (map[row][col] <= map[nextRow][nextCol]) continue;

			visited[row][col] += search(lastRow, lastCol, nextRow, nextCol);
		}
		return visited[row][col];
	}
}
