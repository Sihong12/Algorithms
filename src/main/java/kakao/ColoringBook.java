package kakao;

import java.util.Arrays;

public class ColoringBook {

	public static void main(String[] args) {
		Arrays.toString(new Solution().solution(6, 4, new int[][]{
				{1, 1, 1, 0},
				{1, 2, 2, 0},
				{1, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 3},
				{0, 0, 0, 3}}));
	}
}

class Solution {
	private static final int[] rowDirection = {-1, 0, 1, 0};
	private static final int[] colDirection = {0, -1, 0, 1};
	private static boolean[][] visited;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && !visited[i][j]) {
					int size = DFS(i, j, picture[i][j], picture);
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
					++numberOfArea;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		return answer;
	}

	private int DFS(int row, int col, int color, int[][] picture) {
		int size = 1;
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nextRow = row + rowDirection[i];
			int nextCol = col + colDirection[i];

			if (nextRow < 0 || nextCol < 0 || nextRow >= picture.length || nextCol >= picture[0].length) continue;
			if (picture[nextRow][nextCol] != color || visited[nextRow][nextCol]) continue;

			size += DFS(nextRow, nextCol, color, picture);
		}
		return size;
	}
}
