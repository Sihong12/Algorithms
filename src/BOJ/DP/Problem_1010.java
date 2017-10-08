package BOJ.DP;

import java.util.Scanner;

/**
 * 다리 놓기
 *  서쪽(N)과 동쪽(M)을 연결하는 다리를 지을 수 있는 경우의 수 구하기
 *
 * <규칙>
 * 1. 다리끼리는 서로 겹쳐질 수 없다.
 * 2. 서쪽(N)의 점 개수만큼 다리를 짓는다.
 *
 * <해결>
 * 1. 다리는 겹쳐질 수 없기 때문에 다리 하나를 지었을 때를 생각해본다.
 * 2. N의 처음부터 다리를 지어나가는 경우의 수를 생각해보면 된다.
 * 3. N = 2, M = 4일 때, 다리를 지을 수 있는 경우의 수를 생각해본다.
 *  - N = 1, M = 1에 짓는 경우, N=2, M= 2, 3, 4 : 3개
 *  - N = 1, M = 2에 짓는 경우, N=2, M= 3, 4 : 2개
 *  - N = 1, M = 3에 짓는 경우, N=2, M= 4 : 1개
 * 4. 위와 같은 규칙으로 점화식을 세우면, DP[2][4] = DP[1][3] + DP[1][2] + DP[1][1]이 된다.
 */
public class Problem_1010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while(t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] DP = new int[n+1][m+1];

            if(n == m) {
                System.out.println(1);
                continue;
            }

            for(int i=1; i<=m; i++)
                DP[1][i] = i;

            for(int i=2; i<=n; i++)
                for(int j=i; j<=m; j++)
                    for(int k=j; k>=i; k--)
                        DP[i][j] += DP[i-1][k-1];
            System.out.println(DP[n][m]);
        }
    }

}
