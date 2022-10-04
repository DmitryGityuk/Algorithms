package tasks.LeetCode.array;

import java.util.Arrays;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int expected = 0;
        for (int i = 0; i < nums.length; i++) {
            if (expected != nums[i])
                break;
            expected++;
        }
        return expected;
    }
}

class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int sum2 = 0;
        for (int i : nums) {
            sum2 += i;
        }
        return sum - sum2;
    }
}
