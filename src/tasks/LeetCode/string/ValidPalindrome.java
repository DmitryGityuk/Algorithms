package tasks.LeetCode.string;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/submissions/
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("string cannot be null");
        }
        if (s.isEmpty()) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
