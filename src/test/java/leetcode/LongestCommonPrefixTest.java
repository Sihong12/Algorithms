package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LongestCommonPrefixTest {

	private LongestCommonPrefix solution;

	@Before
	public void setUp() throws Exception {
		solution = new LongestCommonPrefix();
	}

	@Test
	public void normalCase() {
		assertThat(solution.longestCommonPrefix(new String[]{"flower","flow","flight"})).isEqualTo("fl");
	}

	@Test
	public void noCommonPrefix() {
		assertThat(solution.longestCommonPrefix(new String[]{"dog","racecar","car"})).isEqualTo("");
	}
}