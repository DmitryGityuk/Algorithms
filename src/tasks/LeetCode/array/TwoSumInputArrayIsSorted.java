package tasks.LeetCode.array;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int leftPoint = 0;
        int rightPoint = numbers.length - 1;
        while (leftPoint <= rightPoint) {
            int sum = numbers[leftPoint] + numbers[rightPoint];
            if (sum > target) {
                rightPoint -= 1;
            } else if (sum < target) {
                leftPoint += 1;
            } else {
                return new int[]{leftPoint + 1, rightPoint + 1};
            }
        }
        return new int[]{leftPoint + 1, rightPoint + 1};
    }
}
