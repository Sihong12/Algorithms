package BOJ.graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2178 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();
		Maze maze = new Maze(n, m);

		// 입력
		for (int row = 0; row < n; row++) {
			maze.recordPath(row, scanner.next());
		}

		// 미로 탐색
		int minPath = maze.explore();
		System.out.println(minPath);
	}

	static class Maze {

		private static final int CAN_MOVE = 1;
		private static final int[] rowDirection = {-1, 0, 1, 0};
		private static final int[] colDirection = {0, -1, 0, 1};

		private int[][] maze;
		private boolean[][] visited;
		private Queue<Path> queue = new ArrayDeque<>();

		public Maze(int n, int m) {
			maze = new int[n][m];
			visited = new boolean[n][m];
		}

		public void recordPath(int row, String path) {
			for (int col = 0; col < path.length(); col++) {
				maze[row][col] = path.charAt(col) - '0';
			}
		}

		public int explore() {
			visit(0, 0);
			return BFS();
		}

		private int BFS() {
			while (!queue.isEmpty()) {
				Path path = queue.remove();
				for (int i = 0; i < 4; i++) {
					int nextRow = path.row + rowDirection[i];
					int nextCol = path.col + colDirection[i];

					if (nextRow < 0 || nextCol < 0 || nextRow >= maze.length || nextCol >= maze[0].length) continue;
					if (visited[nextRow][nextCol] || maze[nextRow][nextCol] != CAN_MOVE) continue;

					maze[nextRow][nextCol] = maze[path.row][path.col] + 1;
					visit(nextRow, nextCol);
				}
			}
			return maze[maze.length - 1][maze[0].length - 1];
		}

		private void visit(int row, int col) {
			Path path = new Path(row, col);
			queue.add(path);
			visited[row][col] = true;
		}
	}

	static class Path {
		int row;
		int col;

		public Path(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
