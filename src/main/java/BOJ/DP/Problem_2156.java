package BOJ.DP;

import java.util.Scanner;

/**
 * 포도주 시식
 *  n개의 포도주가 있을 때, 최대 마실 수 있는 양을 구하라.
 *
 * <규칙>
 * 1. 연속 3잔을 마실 수 없다.
 *
 * <해결>
 * N번째 잔 기준으로 생각하면,
 * 1. n번째 잔을 마시지 않은 경우
 * 2. n번째 잔을 마시고 이전 잔을 마신 경우
 * 3. n번째 잔을 마시고 이전 잔을 마시지 않은 경우
 *
 * 위 세 가지 경우 중 최대가 되는 경우를 선택하면 그 당시에 선택할 수 있는 최대값을 구할 수 있다.
 *
 * n=1, 무조건 첫 잔을 마셔야 최대
 * n=2, 두 잔 다 마셔야 최대
 * n=3 부터 적용 가능
 */
public class Problem_2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] wine = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            wine[i] = scanner.nextInt();
        }

        // n = 1, n = 2 일 때, 각각 예외처리
        for(int i=1; i<3 && i<=n; i++) {
            if(i == 1) {
                dp[i] = wine[i];
            } else {
                dp[i] = wine[i-1] + wine[i];
            }
        }

        for(int i=3; i<=n; i++) {
            int beforeWine = dp[i-1];
            int thisWineAndBeforeWine = wine[i] + wine[i-1] + dp[i-3];
            int thisWine = wine[i] + dp[i-2];
            dp[i] = max(beforeWine, thisWineAndBeforeWine, thisWine);
        }
        System.out.println(dp[n]);
    }

    public static int max(int first, int second, int third) {
        int max = (first > second)? first:second;
        return (third > max)? third:max;
    }
}
