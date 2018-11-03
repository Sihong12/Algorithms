package codewars.kyu7;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GetTheMiddleCharacterTest {
	
	@Test
	public void evenTests() {
		assertThat(GetTheMiddleCharacter.getMiddle("test")).isEqualTo("es");
		assertThat(GetTheMiddleCharacter.getMiddle("middle")).isEqualTo("dd");
	}

	@Test
	public void oddTests() {
		assertThat(GetTheMiddleCharacter.getMiddle("testing")).isEqualTo("t");
		assertThat(GetTheMiddleCharacter.getMiddle("A")).isEqualTo("A");
	}
}