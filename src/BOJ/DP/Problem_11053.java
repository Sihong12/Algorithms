package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열
 *  수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열의 길이를 출력하라.
 *
 * <해결>
 * 1. LIS(Longest Increasing Subsequence) 알고리즘을 사용.
 * 2. O(N^2)과 O(NlogN) 두 가지 방법이 존재, 여기선 O(N^2)을 사용.
 */
public class Problem_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n+1];
        int[] DP = new int[n+1];

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");

        int max = 0;
        for(int i=1; i<=n; i++) {
            input[i] = Integer.parseInt(tokens.nextToken());
            DP[i] = 1;
            for(int j=1; j<i; j++) {
                if(input[j] < input[i] && DP[j] + 1 > DP[i])
                    DP[i] = DP[j] + 1;
            }
            max = Math.max(max, DP[i]);
        }
        System.out.println(max);
    }
}
