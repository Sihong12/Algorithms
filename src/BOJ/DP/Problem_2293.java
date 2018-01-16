package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 1
 */
public class Problem_2293 {
    public static int[] dp = new int[10001];
    public static int[] coins = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp[0] = 1; // 코인과 동전의 가치가 같을 때의 경우의 수
        for(int i = 1; i <= n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
