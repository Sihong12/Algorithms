package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] answer = new int[2];
		Map<Integer, Integer> cache = new HashMap<>();
		for (int index = 0; index < nums.length; index++) {
			int first = target - nums[index];
			if (cache.containsKey(first)) {
				return new int[]{cache.get(first), index};
			}
			cache.put(nums[index], index);
		}
		return answer;
	}
}
