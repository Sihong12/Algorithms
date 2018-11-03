package codewars.kyu6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Count the smiley faces!
 *
 * (https://www.codewars.com/kata/583203e6eb35d7980400002a/train/java)
 */
public class SmileFaces {

	public static int countSmileys(List<String> arr) {
		// Just Smile :)
		int count = 0;
		Pattern pattern = Pattern.compile("[\\:;][-~]?[\\)D]");
		for(String face : arr) {
			Matcher matcher = pattern.matcher(face);
			if(matcher.matches()) {
				count++;
			}
		}
		return count;
	}

	public static int countSmileysByLambda(List<String> arr) {
		return (int) arr.stream()
				.filter(face -> face.matches("[\\:;][-~]?[\\)D]"))
				.count();
	}

}
