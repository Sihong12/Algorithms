package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UglyNumberTest {

	@Test
	public void example() {
		assertUglyNumber(6, true);
		assertUglyNumber(8, true);
		assertUglyNumber(14, false);
	}

	private void assertUglyNumber(int input, boolean expected) {
		UglyNumber uglyNumber = new UglyNumber();
		boolean isUgly = uglyNumber.isUgly(input);
		assertThat(isUgly).isEqualTo(expected);
	}
}