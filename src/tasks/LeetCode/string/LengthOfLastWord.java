package tasks.LeetCode.string;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') count++;
            else if (count > 0) return count;
        }
        return count;
    }
}
