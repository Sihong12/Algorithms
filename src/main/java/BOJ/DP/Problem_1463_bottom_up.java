package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기 (https://www.acmicpc.net/problem/1463)
 *
 * Bottom-up 으로 해결
 */
public class Problem_1463_bottom_up {
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        System.out.println(calculate(x));
    }

    public static int calculate(int n) {
        dp[1] = 0;
        for(int i=2; i<=n; i++) {
        	dp[i] = dp[i-1] + 1;
        	if(i%2 == 0 && dp[i] > dp[i/2] + 1) {
        		dp[i] = dp[i/2] + 1;
        	}
        	if(i%3 == 0 && dp[i] > dp[i/3] + 1) {
        		dp[i] = dp[i/3] + 1;
        	}
        }
        return dp[n];
    }
}
