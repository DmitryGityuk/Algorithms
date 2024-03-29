package tasks.LeetCode.string;

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left += 1;
            right -= 1;
        }
    }
}
