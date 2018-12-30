package BOJ.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 빠른 A+B (https://www.acmicpc.net/problem/15552)
 *
 * 스페이스바로 구분된 A, B를 입력받아 덧셈 결과 출력 (시간 제한 존재)
 */
public class Problem_15552 {

	public static void main(String[] args) throws IOException {

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out))) {
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				String[] numbers = br.readLine().split(" ");
				wr.write(String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
				wr.newLine();
			}
		}
	}
}
