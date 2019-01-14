package BOJ.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 경로 찾기 (https://www.acmicpc.net/problem/11403)
 */
public class Problem_11403 {

	private static int[][] matrix;
	private static boolean[] visitied;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		visitied = new boolean[n];
		for (int i = 0; i < n; i++) {
			DFS(i);
			for (int j = 0; j < n; j++) {
				if (visitied[j]) {
					matrix[i][j] = 1;
				}
				System.out.print(matrix[i][j] + " ");
			}
			Arrays.fill(visitied, false);
			System.out.println();
		}
	}
	
	private static void DFS(int start) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[start][i] == 1 && !visitied[i]) {
				visitied[i] = true;
				DFS(i);
			}
		}
	}
}
