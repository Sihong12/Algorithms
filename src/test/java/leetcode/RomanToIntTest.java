package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RomanToIntTest {

	private RomanToInt romanToInt;

	@Before
	public void setUp() throws Exception {
		romanToInt = new RomanToInt();
	}

	@Test
	public void normalCase() {
		assertThat(romanToInt.romanToInt("III")).isEqualTo(3);
	}

	@Test
	public void largerThanBeforeCase() {
		assertThat(romanToInt.romanToInt("IV")).isEqualTo(4);
		assertThat(romanToInt.romanToInt("CM")).isEqualTo(900);
		assertThat(romanToInt.romanToInt("CMCD")).isEqualTo(1300);
	}

	@Test
	public void ComplexCase() {
		assertThat(romanToInt.romanToInt("MCMXCIV")).isEqualTo(1994);
	}
}