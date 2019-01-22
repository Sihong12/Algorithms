package BOJ.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem_7576 {

	private static final int RIPE = 1;
	private static final int NOT_RIPE = 0;
	private static final int[] rowDirection = {-1, 0, 1, 0};
	private static final int[] colDirection = {0, -1, 0, 1};

	private static int[][] box;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 입력
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		box = new int[n][m];

		Queue<Tomato> queue = new ArrayDeque<>();
		int notRipeCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = scanner.nextInt();
				if (box[i][j] == RIPE) {
					queue.add(new Tomato(i, j));
				} else if (box[i][j] == NOT_RIPE) {
					++notRipeCount;
				}
			}
		}

		// 토마토 익히기
		int maxDay = 1;
		int ripeCount = 0;
		while (!queue.isEmpty()) {
			Tomato tomato = queue.remove();

			for (int i = 0; i < 4; i++) {
				int nextRow = tomato.row + rowDirection[i];
				int nextCol = tomato.col + colDirection[i];

				if (nextRow < 0 || nextCol < 0 || nextRow >= box.length || nextCol >= box[0].length) continue;
				if (box[nextRow][nextCol] != NOT_RIPE) continue;

				box[nextRow][nextCol] = box[tomato.row][tomato.col] + 1;

				++ripeCount;
				maxDay = Math.max(maxDay, box[nextRow][nextCol]);
				queue.add(new Tomato(nextRow, nextCol));
			}
		}

		if (notRipeCount == ripeCount) {
			System.out.println(maxDay - 1);
		} else {
			System.out.println(-1);
		}
	}

	static class Tomato {
		int row;
		int col;

		public Tomato(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
