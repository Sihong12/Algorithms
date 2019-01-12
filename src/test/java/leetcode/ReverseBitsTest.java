package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ReverseBitsTest {

	@Test
	public void example() {
		ReverseBits solution = new ReverseBits();

		int n = 0b00000010100101000001111010011100;

		assertThat(solution.reverseBits(n)).isEqualTo(0b00111001011110000010100101000000);
	}
}