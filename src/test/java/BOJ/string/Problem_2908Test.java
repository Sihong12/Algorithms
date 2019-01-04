package BOJ.string;

import static BOJ.string.Problem_2908.reverse;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_2908Test {

	@Test
	public void reverseNumber() {
		assertThat(reverse(734)).isEqualTo(437);
		assertThat(reverse(893)).isEqualTo(398);
	}
}