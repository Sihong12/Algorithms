package leetcode;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		if (strs.length == 1) return strs[0];

		String prefix = "";
		for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
			char prefixChar = strs[0].charAt(charIndex);
			for (int index = 1; index < strs.length; index++) {
				if (strs[index].length() <= charIndex || strs[index].charAt(charIndex) != prefixChar) {
					return prefix;
				}
			}
			prefix += prefixChar;
		}
		return prefix;
	}
}
