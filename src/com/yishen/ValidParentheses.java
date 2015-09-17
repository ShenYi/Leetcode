package com.yishen;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yishen on 15/7/19.
 */
public class ValidParentheses {

	@SuppressWarnings("serial")
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Map<Character, Character> mapping = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (mapping.containsKey(a)) {
                stack.push(a);
            } else if (!stack.isEmpty()) {
                char b = stack.pop();
                if (a != mapping.get(b)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
