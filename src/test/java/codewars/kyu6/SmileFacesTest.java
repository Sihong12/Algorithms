package codewars.kyu6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SmileFacesTest {


	@Test
	public void test1() {
		List<String> a = new ArrayList<>();
		a.add(":)"); a.add(":D"); a.add(":-}"); a.add(":-()");
		countSmileys(a, 2);
		countSmileysByLambda(a, 2);
	}

	@Test
	public void test2() {
		List<String> a = new ArrayList<>();
		a.add(":)"); a.add("XD"); a.add(":0}"); a.add("x:-"); a.add("):-"); a.add("D:");
		countSmileys(a, 1);
		countSmileysByLambda(a, 1);
	}

	@Test
	public void test4() {
		List<String> a =  new ArrayList<>();
		a.add(":)"); a.add(":D"); a.add("X-}"); a.add("xo)"); a.add(":X"); a.add(":-3"); a.add(":3");
		countSmileys(a, 2);
		countSmileysByLambda(a, 2);
	}

	@Test
	public void test5() {
		List<String> a =  new ArrayList<>();
		a.add(":)"); a.add(":)"); a.add("x-]"); a.add(":ox"); a.add(";-("); a.add(";-)"); a.add(";~("); a.add(":~D");
		countSmileys(a, 4);
		countSmileysByLambda(a, 4);
	}

	private void countSmileys(List<String> faces, int expected) {
		assertThat(SmileFaces.countSmileys(faces)).isEqualTo(expected);
	}

	private void countSmileysByLambda(List<String> faces, int expected) {
		assertThat(SmileFaces.countSmileysByLambda(faces)).isEqualTo(expected);
	}
}