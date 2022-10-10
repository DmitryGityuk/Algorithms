package tasks.LeetCode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counter = new int[30];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            Map<Character, Integer> s1 = new HashMap<>();
            Map<Character, Integer> s2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                s1.put(s.charAt(i), s1.getOrDefault(s.charAt(i), 0) + 1);
                s2.put(t.charAt(i), s2.getOrDefault(t.charAt(i), 0) + 1);
            }
            for (char c : s1.keySet()) {
                if (!s2.containsKey(c) || !s1.get(c).equals(s2.get(c))) return false;
            }
            return true;
        }
    }

}
