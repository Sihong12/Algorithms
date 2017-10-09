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
 * 2. O(N^2)과 O(NlogN) 두 가지 방법이 존재, 여기선 O(NlogN)을 사용.
 */
public class Problem_11053_nlogn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        int[] input = new int[n];
        for(int i=0; i<n; i++) {
            input[i] = Integer.parseInt(tokens.nextToken());
        }

        int[] subsequence = new int[n];
        subsequence[0] = input[0];
        int length = 1;
        for(int i=1; i<n; i++) {
            if(input[i] < subsequence[0]) {
                subsequence[0] = input[i];
            } else if(input[i] > subsequence[length-1]) {
                subsequence[length++] = input[i];
            } else {
                int replaceIndex = lowerBound(subsequence, 0, length, input[i]);
                subsequence[replaceIndex] = input[i];
            }
        }

        System.out.println(length);
    }

    public static int lowerBound(int[] arr, int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;

            int midVal = arr[mid];

            if(midVal < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
