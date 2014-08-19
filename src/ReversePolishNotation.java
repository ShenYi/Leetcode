import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 * 
 * @author yishen
 *
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] s1 = {"2", "1", "+", "3", "*"};
        String[] s2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s1));
        System.out.println(evalRPN(s2));

    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<Integer>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                if (operands.size() < 2) {
                    return 0;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 + op2);
            } else if ("-".equals(s)) {
                if (operands.size() < 2) {
                    return 0;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 - op2);
            } else if ("*".equals(s)) {
                if (operands.size() < 2) {
                    return 0;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                operands.push(op1 * op2);
            } else if ("/".equals(s)) {
                if (operands.size() < 2) {
                    return 0;
                }
                int op2 = operands.pop();
                int op1 = operands.pop();
                if (op2 == 0)
                    return 0;
                operands.push(op1 / op2);
            } else {
                try {
                    int value = Integer.parseInt(s);
                    operands.push(value);
                } catch (ArithmeticException e) {
                    return 0;
                }
            }

        }
        if (operands.size() == 1)
            return operands.pop();
        else
            return 0;

    }
}
