package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UncommonWordsFromTwoSentencesTest {

	@Test
	public void example() {
		UncommonWordsFromTwoSentences solution = new UncommonWordsFromTwoSentences();
		assertThat(solution.uncommonFromSentences("this apple is sweet", "this apple is sour"))
				.containsExactly("sweet", "sour");
	}

	@Test
	public void example2() {
		UncommonWordsFromTwoSentences solution = new UncommonWordsFromTwoSentences();
		assertThat(solution.uncommonFromSentences("apple apple", "banana"))
				.containsExactly("banana");
	}
}