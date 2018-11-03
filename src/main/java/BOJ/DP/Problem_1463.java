package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기 (https://www.acmicpc.net/problem/1463)
 *
 * 3가지 연산을 이용해 가장 적은 횟수로 1에 도달하는 경우를 구해야한다.
 * 자바에서 연산을 진행하는 경우는 스택이 한정되어 있기 때문에 스택오버플로우가 발생한다.
 * Bottom-up 방식으로 풀어야 한다.
 */
public class Problem_1463 {
    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        System.out.println(calculate(x));
    }

    public static int calculate(int n) {
        if(n == 1) return 0;
        if(dp[n] > 0) return dp[n]; // 이미 연산을 한 경우
        dp[n] = calculate(n-1) + 1;

        if(n % 2 == 0) {
            int countOfCalculation = calculate(n / 2) + 1;
            if(dp[n] > countOfCalculation) {
                dp[n] = countOfCalculation;
            }
        } else if(n % 3 == 0) {
            int countOfCalculation = calculate(n / 3) + 1;
            if(dp[n] > countOfCalculation) {
                dp[n] = countOfCalculation;
            }
        }
        return dp[n];
    }


}
