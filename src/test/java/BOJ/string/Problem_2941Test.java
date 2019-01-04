package BOJ.string;

import static BOJ.string.Problem_2941.count;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class Problem_2941Test {

	@Test
	public void example() {
		assertThat(count("ljes=njak")).isEqualTo(6);
		assertThat(count("ddz=z=")).isEqualTo(3);
		assertThat(count("nljj")).isEqualTo(3);
		assertThat(count("c=c=")).isEqualTo(2);
	}
}