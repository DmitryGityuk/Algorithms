package tasks.LeetCode.string;

/**
 * 1544. Make The String Great
 * https://leetcode.com/problems/make-the-string-great/
 */
public class MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int resultLength = sb.length();
            if (resultLength != 0 && Math.abs(sb.charAt(resultLength - 1) - ch) == 32) {
                sb.deleteCharAt(resultLength - 1);
            } else sb.append(ch);
        }
        return sb.toString();
    }
}
