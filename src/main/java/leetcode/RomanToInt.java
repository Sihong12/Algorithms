package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	private final Map<Character, Integer> intByRoman = new HashMap<>();

	public RomanToInt() {
		intByRoman.put('I', 1);
		intByRoman.put('V', 5);
		intByRoman.put('X', 10);
		intByRoman.put('L', 50);
		intByRoman.put('C', 100);
		intByRoman.put('D', 500);
		intByRoman.put('M', 1000);
	}

	public int romanToInt(String s) {
		int number = 0;
		for (int index = 0; index < s.length(); index++) {
			if ((index + 1 < s.length()) && intByRoman.get(s.charAt(index + 1)) > intByRoman.get(s.charAt(index))) {
				number += intByRoman.get(s.charAt(index + 1)) - intByRoman.get(s.charAt(index));
				index++;
			} else {
				number += intByRoman.get(s.charAt(index));
			}
		}
		return number;
	}
}
