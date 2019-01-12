package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ValidAnagramTest {

	@Test
	public void example() {
		ValidAnagram solution = new ValidAnagram();

		String s = "anagram";
		String t = "nagaram";
		assertThat(solution.isAnagram(s, t)).isTrue();
	}
}