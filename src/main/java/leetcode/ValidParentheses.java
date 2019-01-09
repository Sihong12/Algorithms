package leetcode;

import java.util.Stack;

/**
 * Valid Parenthese (https://leetcode.com/problems/valid-parentheses/)
 */
public class ValidParentheses {

	private Stack<Character> stack = new Stack<>();

	public boolean isValid(String parentheses) {
		for (char character : parentheses.toCharArray()) {
			if (character == '(') {
				stack.push(')');
			} else if (character == '{') {
				stack.push('}');
			} else if (character == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != character) {
				return false;
			}
		}

		return stack.isEmpty();
	}
}
