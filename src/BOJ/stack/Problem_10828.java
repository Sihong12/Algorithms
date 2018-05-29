package BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스택 (https://www.acmicpc.net/problem/10828)
 */
public class Problem_10828 {

	static final Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int countOfOperation = Integer.parseInt(br.readLine());
		for(int i=0; i<countOfOperation; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			switch (token.nextToken()) {
				case "push" :
					stack.push(Integer.parseInt(token.nextToken()));
					break;
				case "pop" :
					System.out.println(stack.isEmpty()? -1:stack.pop());
					break;
				case "size" :
					System.out.println(stack.size());
					break;
				case "empty" :
					System.out.println(stack.isEmpty()? 1:0);
					break;
				case "top" :
					System.out.println(stack.isEmpty()? -1:stack.lastElement());
					break;
			}
		}
	}
}
