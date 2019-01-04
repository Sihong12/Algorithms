package BOJ.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_5622Test {

	@Test
	public void calculateTime() {
		String dialWord = "UNUCIC";
		int time = Problem_5622.calculateTime(dialWord);
		assertThat(time).isEqualTo(36);
	}
}