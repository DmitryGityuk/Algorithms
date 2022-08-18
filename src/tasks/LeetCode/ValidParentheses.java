package tasks.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!brackets.containsKey(c)) {
                characterStack.push(c);
            } else {
                char top = characterStack.isEmpty() ? '?' : characterStack.pop();
                if (top != brackets.get(c)) {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }
}
