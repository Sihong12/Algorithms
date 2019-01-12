package leetcode;

import java.util.Arrays;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		char[] arr1 = sortByCharArray(s);
		char[] arr2 = sortByCharArray(t);

		return Arrays.equals(arr1, arr2);
	}

	private char[] sortByCharArray(String value) {
		char[] arr = value.toCharArray();
		Arrays.sort(arr);
		return arr;
	}
}
