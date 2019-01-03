package BOJ.string;

import static BOJ.string.Problem_1316.check;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_1316Test {

	@Test
	public void exampleCase() {
		assertThat(check("happy")).isEqualTo(1);
		assertThat(check("new")).isEqualTo(1);
		assertThat(check("year")).isEqualTo(1);
	}

	@Test
	public void notGroupWord() {
		assertThat(check("hapa")).isEqualTo(0);
		assertThat(check("haapyp")).isEqualTo(0);
	}
}