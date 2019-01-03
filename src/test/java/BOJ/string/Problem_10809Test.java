package BOJ.string;

import static BOJ.string.Problem_10809.solve;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_10809Test {

	@Test
	public void example() {
		assertThat(solve("baekjoon"))
				.containsExactly(1, 0, -1, -1, 2, -1, -1, -1, -1, 4, 3, -1, -1, 7, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
	}

	@Test
	public void duplicatedCase() {
		assertThat(solve("bbbbbbb"))
				.startsWith(-1, 0)
				.containsOnly(-1, 0);
	}
}