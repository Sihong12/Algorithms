package codewars.kyu7;

/**
 * Complementary DNA
 *
 * (https://www.codewars.com/kata/554e4a2f232cdd87d9000038/train/java)
 */
public class ComplementaryDNA {

	public static String makeComplement(String dna) {
		StringBuilder word = new StringBuilder();
		for(char symbol : dna.toCharArray()) {
			if(symbol == 'A') {
				word.append('T');
			} else if(symbol == 'T') {
				word.append('A');
			} else if(symbol == 'C') {
				word.append('G');
			} else if(symbol == 'G') {
				word.append('C');
			}
		}
		return word.toString();
	}
}
