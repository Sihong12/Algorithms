package leetcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TwoSumTest {

	private TwoSum solution;

	@Before
	public void setUp() throws Exception {
		solution = new TwoSum();
	}

	@Test
	public void positiveNumber() {
		assertThat(solution.twoSum(new int[]{2, 7, 11, 15}, 9)).containsExactly(0, 1);
	}

	@Test
	public void sameNumber() {
		assertThat(solution.twoSum(new int[]{3, 3}, 6)).containsExactly(0, 1);
	}

	@Test
	public void positiveAndNegativeNumber() {
		assertThat(solution.twoSum(new int[]{-1, 12, -5, -8, -3}, 9)).containsExactly(1, 4);
	}
}