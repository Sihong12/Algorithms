package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * 2가지 경우의 수가 존재
 * 
 * <규칙>
 * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
 * 2. 연속된 세 개의 계단을 모두 밟아서는 안된다. 단, 시작점은 계단에 포함되지 않는다.
 * 3. 마지막 도착 계단은 반드시 밟아야 한다.
 * 
 * <해결>
 * 3번을 밟으면 안되기 때문에 마지막 계단을 밟았을 때, 2가지의 경우의 수가 존재
 * 1. 마지막 계단 바로 전 계단을 밟았을 경우는 그 전 계단을 밟을 수 없다. (N-3 -> N-1 -> N)
 * 	  -> N-2 -> N-1 -> N을 밟았다면 그전에 연속되었을 가능성이 존재하기 때문에 안됨
 * 2. 마지막 2번째 전 계단을 밟았을 때
 * 
 */
public class Problem_2579 {
    public static int[] dp = new int[301];
    public static int[] stairs = new int[301];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
        	stairs[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = stairs[1]; // 첫 번째만 밟는 경우
        dp[2] = Math.max(stairs[1] + stairs[2], stairs[2]); // 첫 번째를 밟고 두 번째를 밟는 경우 | 두 번째만 밟는 경우
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]); // 첫 번째 밟고 세 번째를 밟는 경우 | 두 번째를 밟고 세번째를 밟는 경우
        for(int i=4; i<=n; i++) {
        	dp[i] = Math.max(stairs[i] + dp[i-2], stairs[i] + stairs[i-1] + dp[i-3]);
        }
        
        System.out.println(dp[n]);
    }
}    