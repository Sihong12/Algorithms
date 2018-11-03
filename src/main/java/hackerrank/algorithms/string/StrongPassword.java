package hackerrank.algorithms.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/strong-password/problem
 */

public class StrongPassword {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		boolean hasDigit = false;
		boolean hasLowerCase = false;
		boolean hasUpperCase= false;
		boolean hasSpecialCharacter = false;

		for (int i = 0; i < password.length(); i++) {
			char character = password.charAt(i);

			if(Character.isDigit(character)) {
				hasDigit = true;
			} else if(Character.isLowerCase(character)) {
				hasLowerCase = true;
			} else if(Character.isUpperCase(character)) {
				hasUpperCase = true;
			} else if(Character.isSpaceChar(character)){
				hasSpecialCharacter = true;
			}

		}

		int minimumNumber = 4;
		if(hasDigit) {
			minimumNumber -= 1;
		} else if(hasLowerCase) {
			minimumNumber -= 1;
		} else if(hasUpperCase) {
			minimumNumber -= 1;
		} else if(hasSpecialCharacter) {
			minimumNumber -= 1;
		}
		return Math.max(minimumNumber, 6-n);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		System.out.println(answer);
	}
}
