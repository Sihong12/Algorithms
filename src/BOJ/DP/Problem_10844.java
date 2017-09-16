package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 쉬운 계단수
 *
 */
public class Problem_10844 {
    public static int[][] dp = new int[101][10];
    public static final int DIVISOR = 1000000000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++) {
        	dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
        	for(int j=0; j<=9; j++) {
        		dp[i][j] = 0;
        		if(j-1 >= 0) dp[i][j] += dp[i-1][j-1];
        		if(j+1 <= 9) dp[i][j] += dp[i-1][j+1];
        		dp[i][j] %= DIVISOR;
        	}
        }
        
        long result = 0L;
        for(int i=0; i<=9; i++) {
        	result += dp[n][i];
        	result %= DIVISOR;
        }
        System.out.println(result % DIVISOR);
    }
}
