package BOJ.notation;

import java.util.Scanner;

public class Problem_1212 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String octal = scanner.next();
		System.out.println(convert(octal));
	}

	public static String convert(String octal) {
		String[] octalToBinaryFirstDigit = new String[]{"0", "1", "10", "11", "100", "101", "110", "111"};
		String[] octalToBinary = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};

		StringBuilder binary = new StringBuilder(octal.length() * 3);
		binary.append(octalToBinaryFirstDigit[octal.charAt(0) - '0']);
		for (int index = 1; index < octal.length(); index++) {
			binary.append(octalToBinary[octal.charAt(index) - '0']);
		}
		return binary.toString();
	}
}
