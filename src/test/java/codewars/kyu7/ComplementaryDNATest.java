package codewars.kyu7;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ComplementaryDNATest {

	@Test
	public void makeComplement() {
		assertComplement("AAAA", "TTTT");
		assertComplement("TTTT", "AAAA");
		assertComplement("TAACG", "ATTGC");
		assertComplement("CATA", "GTAT");
	}

	private void assertComplement(String word, String expected) {
		assertThat(ComplementaryDNA.makeComplement(word)).isEqualTo(expected);
	}
}