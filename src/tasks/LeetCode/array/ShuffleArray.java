package tasks.LeetCode.array;

/**
 * 1470. Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = n;
        for (int i = 1; i < nums.length; i += 2) {
            result[i - 1] = nums[left++];
            result[i] = nums[right++];
        }
        return result;
    }
}
