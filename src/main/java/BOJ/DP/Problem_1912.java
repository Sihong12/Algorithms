package BOJ.DP;

import java.util.Scanner;

/**
 * 연속합
 *  연속하는 수를 선택하여 구할 수 있는 최대합
 *
 * <규칙>
 * 1. 무조건 하나 이상 선택해야한다.
 *
 * <해결>
 * 1. 선택한 값과 이전까지 구한 값을 비교한다.
 * 2-1. 선택한 값이 크면 선택한 값부터 다시 시작한다.
 * 2-2. 이전까지 구한 값과 선택한 값을 더했을 때, 선택한 값보다 크면 계속 진행
 */
public class Problem_1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            int input = scanner.nextInt();
            int sum = dp[i-1] + input;
            if(input > sum) {
                dp[i] = input;
            } else {
                dp[i] = sum;
            }
        }

        int max = dp[1];
        for(int i=2; i<=n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
