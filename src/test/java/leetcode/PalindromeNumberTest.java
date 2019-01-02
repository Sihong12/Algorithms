package leetcode;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PalindromeNumberTest {

	private PalindromeNumber palindromeNumber;

	@Before
	public void setUp() throws Exception {
		palindromeNumber = new PalindromeNumber();
	}

	@Test
	public void positiveNumber() {
		assertThat(palindromeNumber.isPalindrome(1221)).isTrue();
	}

	@Test
	public void positiveNumber2() {
		assertThat(palindromeNumber.isPalindrome(12321)).isTrue();
	}

	@Test
	public void negativeNumber() {
		assertThat(palindromeNumber.isPalindrome(-1221)).isFalse();
	}

	@Test
	public void includingZeroAtEnd() {
		assertThat(palindromeNumber.isPalindrome(10)).isFalse();
	}
}