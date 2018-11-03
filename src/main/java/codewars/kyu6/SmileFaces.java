package codewars.kyu6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
