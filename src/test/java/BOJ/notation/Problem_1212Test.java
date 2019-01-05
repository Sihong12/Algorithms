package BOJ.notation;

import static BOJ.notation.Problem_1212.convert;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_1212Test {

	@Test
	public void example() {
		assertThat(convert("314")).isEqualTo("11001100");
	}
}