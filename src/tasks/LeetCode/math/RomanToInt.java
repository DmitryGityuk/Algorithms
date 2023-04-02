package tasks.LeetCode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 */


public class RomanToInt {
    Map<Character, Integer> map = new HashMap<>();

    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < prev) {
                res -= curr;
            } else res += curr;
            prev = curr;
        }
        return res;
    }
}
