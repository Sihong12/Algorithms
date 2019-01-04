package BOJ.DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 함수
 *
 * n을 구하기 위해 필요한 0과 1의 개수 반환하는 문제
 *
 * -------------------------------------------------------
 *
 * 피보나치 수열
 * 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이다.
 *
 * n = 0 : 0
 * n = 1 : 1
 * n > 1 : Fn = Fn-1 + Fn-2
 */
public class Problem_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] dp = new int[40];
        dp[0] = 1;
        dp[1] = 1;
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                System.out.println("1 0");
            } else if (n == 1) {
                System.out.println("0 1");
            } else {
                fibonacci(n, dp);
                System.out.println(dp[n - 2] + " " + dp[n - 1]);
            }
        }
    }

    public static int fibonacci(int n, int[] dp) {
    	if (n <= 2) {
    	    return dp[n - 1];
        } else if (dp[n - 1] != 0) {
    	    return dp[n - 1];
        } else {
            dp[n - 1] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
            return dp[n - 1];
        }
    }
}
