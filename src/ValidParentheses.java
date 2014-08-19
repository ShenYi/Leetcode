import java.util.*;

/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * 
 * @author yishen
 * 
 */
public class ValidParentheses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ValidParentheses instance = new ValidParentheses();
        System.out.print(instance.isValid("{{{{}}}}"));
    }

    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        Set<Character> left = new HashSet<Character>();
        left.add('{');
        left.add('(');
        left.add('[');
        Set<Character> right = new HashSet<Character>();
        right.add('}');
        right.add(')');
        right.add(']');

        Map<Character, Character> rightToLeft = new HashMap<Character, Character>();
        rightToLeft.put('}', '{');
        rightToLeft.put(']', '[');
        rightToLeft.put(')', '(');
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (left.contains(c)) {
                stack.push(c);
            } else if (right.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cc = stack.pop();
                    if (rightToLeft.get(c) != cc) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
