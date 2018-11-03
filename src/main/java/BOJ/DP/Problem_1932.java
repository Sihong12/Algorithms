package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Scanner;

/**
 * 숫자 삼각형
 *  맨 위층에서 하나의 수를 선택하면서 아래층으로 내려갈 때, 최하층에 도달했을 때의 최대값을 구하라
 *
 * <규칙>
 * 1. 선택된 수의 아래층의 대각선 왼쪽, 대각선 오른쪽으로만 이동 가능
 *
 * <해결>
 * 1. 왼쪽을 선택한 경우와 오른쪽을 선택한 경우의 최대값을 계산하여 저장한다.
 *  1-1. 이미 이전에 선택된 경우라면, 둘 중 더 큰 값을 저장한다.
 * 2. 최하층에 저장된 값들의 최대값을 구한다.
 */
public class Problem_1932 {
    public static void main(String[] args) throws IOException {
        // 스캐너 사용전
        //        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //        int n = Integer.parseInt(br.readLine());
        //
        //        int[][] dp = new int[n][n];
        //        int[][] triangle = new int[n][];
        //        for(int i=0; i<n; i++) {
        //            String[] input = br.readLine().split(" ");
        //            triangle[i] = new int[input.length];
        //            for(int j=0; j<input.length; j++) {
        //                triangle[i][j] = Integer.parseInt(input[j]);
        //            }
        //        }

        // 이런 문제는 스캐너를 사용하는게 더 깔끔하다.
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] dp = new int[n][n];
        int[][] triangle = new int[n][n];
        for(int i=0; i < n; i++) {
            for(int j=0; j <= i; j++) {
                triangle[i][j] = scanner.nextInt();
            }
        }

        dp[0][0] = triangle[0][0];
        for(int i=0; i<triangle.length-1; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                int left = dp[i][j] + triangle[i+1][j];
                int right = dp[i][j] + triangle[i+1][j+1];
                dp[i+1][j] = Math.max(dp[i+1][j], left);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], right);
            }
        }

        int max = 0;
        for(int i=0; i<dp.length; i++) {
            max = Math.max(dp[dp.length-1][i], max);
        }
        System.out.println(max);
    }
}
