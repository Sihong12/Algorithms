package BOJ.string;

import static BOJ.string.Problem_2675.repeat;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_2675Test {

	@Test
	public void exampleCase1() {
		assertThat(repeat(3, "ABC")).isEqualTo("AAABBBCCC");
	}

	@Test
	public void exampleCase2() {
		assertThat(repeat(5, "/HTP")).isEqualTo("/////HHHHHTTTTTPPPPP");
	}
}