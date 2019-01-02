package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerTest {

	private ReverseInteger reverseInteger;

	@Before
	public void setUp() throws Exception {
		reverseInteger = new ReverseInteger();
	}

	@Test
	public void reversePositiveInteger() {
		assertThat(reverseInteger.reverse(123)).isEqualTo(321);
	}

	@Test
	public void reverseNegativeInteger() {
		assertThat(reverseInteger.reverse(-1592)).isEqualTo(-2951);
	}

	@Test
	public void reverseMaxInteger() {
		assertThat(reverseInteger.reverse(Integer.MAX_VALUE)).isEqualTo(0);
	}

	@Test
	public void reverseMinInteger() {
		assertThat(reverseInteger.reverse(Integer.MIN_VALUE)).isEqualTo(0);
	}
}