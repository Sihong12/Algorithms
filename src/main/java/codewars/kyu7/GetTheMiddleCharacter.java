package codewars.kyu7;

/**
 * Get the Middle Character
 *
 * (https://www.codewars.com/kata/get-the-middle-character)
 */
public class GetTheMiddleCharacter {

	public static String getMiddle(String word) {
		int halfLength = word.length() / 2;
		if(word.length() % 2 == 0) {
			return word.substring(halfLength - 1, halfLength + 1);
		}
		return word.substring(halfLength, halfLength + 1);
	}
}
