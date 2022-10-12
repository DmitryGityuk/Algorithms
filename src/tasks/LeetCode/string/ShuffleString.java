package tasks.LeetCode.string;

/**
 * 1528. Shuffle String
 * https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] answer = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            answer[indices[i]] = s.charAt(i);
        }
        return String.valueOf(answer);
    }
}
