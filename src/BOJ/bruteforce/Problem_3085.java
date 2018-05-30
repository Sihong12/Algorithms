package BOJ.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사탕게임 (https://www.acmicpc.net/problem/3085)
 */
public class Problem_3085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int boardSize = Integer.parseInt(br.readLine());
		char[][] board = new char[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int maxCountOfcandies = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize - 1; j++) {
				if (swapHorizontal(board, i, j)) {
					maxCountOfcandies = Math.max(maxCountOfcandies, count(board));
					swapHorizontal(board, i, j);
				}

				if (swapVertical(board, j, i)) {
					maxCountOfcandies = Math.max(maxCountOfcandies, count(board));
					swapVertical(board, j, i);
				}
			}

		}
		System.out.println(maxCountOfcandies);
	}

	public static boolean swapHorizontal(char[][] board, int i, int j) {
		if (board[i][j] == board[i][j + 1]) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = board[i][j + 1];
		board[i][j + 1] = temp;
		return true;
	}

	public static boolean swapVertical(char[][] board, int i, int j) {
		if (board[i][j] == board[i + 1][j]) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = board[i + 1][j];
		board[i + 1][j] = temp;
		return true;
	}

	public static int count(char[][] board) {
		int maxCountOfCandies = 0;
		int count;
		for (int i = 0; i < board.length; i++) {
			count = 1;
			for (int j = 0; j < board.length - 1; j++) {
				if (board[i][j] == board[i][j + 1]) {
					count++;
				} else {
					maxCountOfCandies = Math.max(maxCountOfCandies, count);
					count = 1;
				}
			}
			maxCountOfCandies = Math.max(maxCountOfCandies, count);
		}

		for (int i = 0; i < board.length; i++) {
			count = 1;
			for (int j = 0; j < board.length - 1; j++) {
				if (board[j][i] == board[j + 1][i]) {
					count++;
				} else {
					maxCountOfCandies = Math.max(maxCountOfCandies, count);
					count = 1;
				}
			}
			maxCountOfCandies = Math.max(maxCountOfCandies, count);
		}

		return maxCountOfCandies;
	}
}
