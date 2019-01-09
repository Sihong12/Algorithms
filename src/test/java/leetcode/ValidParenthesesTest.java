package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest {

	private ValidParentheses validParentheses;

	@Before
	public void setUp() throws Exception {
		validParentheses = new ValidParentheses();
	}

	@Test
	public void isValid() {
		assertValidation("[]", true);
		assertValidation("[][]{}", true);
	}

	@Test
	public void isValidComplex() {
		assertValidation("[{}]", true);
		assertValidation("(())", true);
	}

	@Test
	public void isInvalid() {
		assertValidation("(]", false);
		assertValidation("([)]", false);
	}

	@Test
	public void emptyString() {
		assertValidation("", true);
	}

	private void assertValidation(String parentheses, boolean expected) {
		assertThat(validParentheses.isValid(parentheses)).isEqualTo(expected);
	}
}