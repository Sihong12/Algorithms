package leetcode;

public class ReverseInteger {

	public int reverse(int x) {
		int reverseNumber = 0;
		while (x != 0) {
			int digit = x % 10;
			x /= 10;
			if (reverseNumber > Integer.MAX_VALUE / 10
					|| (reverseNumber == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
			if (reverseNumber < Integer.MIN_VALUE / 10
					|| (reverseNumber == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

			reverseNumber = reverseNumber * 10 + digit;
		}
		return reverseNumber;
	}

//	public int reverse(int x) {
//		StringBuilder result = new StringBuilder();
//		String number = String.valueOf(x);
//		if (number.contains("-")) {
//			result.append("-");
//			number = number.substring(1);
//		}
//
//		for (int index = number.length() - 1; index >= 0; index--) {
//			result.append(number.charAt(index));
//		}
//
//		try {
//			return Integer.parseInt(result.toString());
//		} catch (NumberFormatException e) {
//			return 0;
//		}
//	}
}

