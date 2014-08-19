import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/plus-one/
 * 
 * @author yishen
 * 
 */
public class PlusOne {

    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        final int[] result = new int[digits.length + 1];

        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (add == 0) {
                result[i + 1] = digits[i];
            } else if (digits[i] == 9) {
                result[i + 1] = 0;
                add = 1;
            } else {
                result[i + 1] = digits[i] + 1;
                add = 0;
            }
        }
        if (add == 0) {
            return Arrays.copyOfRange(result, 1, result.length);
        } else {
            result[0] = 1;
            return result;
        }
    }
}
