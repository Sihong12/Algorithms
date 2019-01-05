package BOJ.search;

import static BOJ.search.Problem_1920.existNumber;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class Problem_1920Test {

	@Test
	public void exists() {
		int[] actual = existNumber(new int[]{4, 1, 5, 2, 3}, new int[]{1, 3, 7, 9, 5});
		System.out.println(Arrays.toString(actual));
		assertThat(actual).containsExactly(1, 1, 0, 0, 1);
	}

//	@Test
//	public void notExists() {
//		assertThat(existNumber(6, new int[]{4, 1, 5, 2, 3})).isEqualTo(0);
//	}
}