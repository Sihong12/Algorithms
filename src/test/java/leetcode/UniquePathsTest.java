package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UniquePathsTest {

	@Test
	public void example() {
		UniquePaths solution = new UniquePaths();
		int output = solution.uniquePaths(7, 3);
		assertThat(output).isEqualTo(28);
	}
}