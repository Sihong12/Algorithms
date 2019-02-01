package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Uncommon Words from Two Sentences (https://leetcode.com/problems/uncommon-words-from-two-sentences/)
 *
 * 주어진 두 개의 문자에서 중복되지 않은 단어 찾기
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 */
public class UncommonWordsFromTwoSentences {

	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> map = new HashMap<>();
		countWords(map, A);
		countWords(map, B);

		List<String> uncommonWords = new ArrayList<>();
		for (String word : map.keySet()) {
			if (map.get(word) == 1) {
				uncommonWords.add(word);
			}
		}
		return uncommonWords.toArray(new String[uncommonWords.size()]);
	}

	private void countWords(Map<String, Integer> map, String words) {
		for (String word : words.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
	}
}
