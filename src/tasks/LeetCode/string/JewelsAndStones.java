package tasks.LeetCode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        Set<Character> chars = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            chars.add(c);
        }
        for (Character c : stones.toCharArray()) {
            if (chars.contains(c)) {
                result++;
            }
        }
        return result;
    }
}
