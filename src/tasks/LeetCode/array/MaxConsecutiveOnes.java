package tasks.LeetCode.array;

/**
 * 485. Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        int lastNum = -1;
        for (int n : nums){
            if (lastNum != n){
                lastNum = n;
                count = 1;
            } else count += 1;
            if (n == 1){
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
