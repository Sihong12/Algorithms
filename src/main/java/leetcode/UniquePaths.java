package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], 0);
		}
		return setUniquePath(m - 1, n - 1, dp);
	}

	private int setUniquePath(int m, int n, int[][] dp) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 && n == 0) {
			return 1;
		}
		if (dp[m][n] == 0) {
			dp[m][n] = setUniquePath(m - 1, n, dp) + setUniquePath(m, n - 1, dp);
		}
		return dp[m][n];
	}
}
