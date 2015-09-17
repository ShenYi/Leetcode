package com.yishen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yishen on 15/7/20.
 */
public class GenerateParentheses {
    public static void main(String[] args) {

        System.out.println(new GenerateParentheses().generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        generateHelper(result, "", n, n);

        return result;
    }

    public void generateHelper(List<String> result, String s, int left, int right) {
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            generateHelper(result, s + "(", left - 1, right);
        }

        if (right > 0) {
            generateHelper(result, s + ")", left, right - 1);
        }
    }
}
