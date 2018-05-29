package BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호 (https://www.acmicpc.net/problem/9012)
 */
public class Problem_9012 {

	static final Stack<String> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			stack.clear();
			String[] brackets = br.readLine().split("");
			boolean isVPS = true;
			for (String bracket : brackets) {
				if ("(".equals(bracket)) {
					stack.push(bracket);
				} else if (!stack.isEmpty()) {
					stack.pop();
				} else {
					isVPS = false;
					break;
				}
			}

			System.out.println(isVPS && stack.isEmpty() ? "YES" : "NO");
		}
	}
}
