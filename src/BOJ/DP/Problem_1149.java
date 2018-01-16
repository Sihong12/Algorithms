package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * RGB �Ÿ�
 * 
 * 1. �̿��� ���� ������ ĥ�� �� ����.
 * 2. ó���� �������� �̿��� �ƴϴ�.
 * 
 * -> �� ���򺰷� �ּҷ� ĥ�� �� �ִ� ����� ���Ѵ�. 
 * -> ���򺰷� ���� �ּҰ��� ���Ѵ�.
 */

public class Problem_1149 {
    public static int[] dp = new int[3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
        	int[] rgb = Arrays.stream((br.readLine()).split(" "))
        	        	.mapToInt(Integer::parseInt).toArray();
        	int pre_r = dp[0], pre_g = dp[1], pre_b = dp[2];
        	
        	dp[0] = rgb[0] + min(pre_g, pre_b);
        	dp[1] = rgb[1] + min(pre_r, pre_b);
        	dp[2] = rgb[2] + min(pre_r, pre_g);
        }
        
        System.out.println(min(dp[0], dp[1], dp[2]));
    }
    
    public static int min(int first, int second) {
    	return (first < second)? first:second;
    }
    
    public static int min(int first, int second, int third) {
    	int min = (first < second)? first:second;
    	return (min < third)? min:third;
    	
    }
}