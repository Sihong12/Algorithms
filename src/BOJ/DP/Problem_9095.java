package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 (https://www.acmicpc.net/problem/9095)
 *
 */
public class Problem_9095 {
    public static int[] dp = new int[11];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testCase = Integer.parseInt(br.readLine());
        
        dp[1] = 1;
        dp[2] = dp[1] + 1;
        dp[3] = dp[1] + dp[2] + 1;
        
        for(int i=1; i<=testCase; i++) {
        	int n = Integer.parseInt(br.readLine());
        	for(int j=4; j<=n; j++) {
        		dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; 
        	}
        	System.out.println(dp[n]);
        }
    }
}    
