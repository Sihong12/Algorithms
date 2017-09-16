package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 붕어빵
 *
 */
public class Problem_11052 {
    public static int[] dp = new int[1001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n+1];
        String[] prices = br.readLine().split("\\s");
        for(int i=1; i<=n; i++) {
        	p[i] = Integer.parseInt(prices[i-1]);
        }
        
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=i; j++) {
        		dp[i] = max(dp[i], dp[i-j] + p[j]);
        	}
        }
        
        System.out.println(dp[n]);
    }
    
    public static int max(int first, int second) {
    	return (first > second)? first:second;
    }
}
