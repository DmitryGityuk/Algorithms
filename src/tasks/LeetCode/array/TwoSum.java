package tasks.LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution for defined input data");
    }

    class SolutionTwo {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int requiredNUm = target - nums[i];

                if (map.containsKey(requiredNUm) && map.get(requiredNUm) != i) {
                    return new int[]{i, map.get(requiredNUm)};
                }
            }
            throw new IllegalArgumentException("No solution for defined input data");
        }
    }
}
