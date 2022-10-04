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
