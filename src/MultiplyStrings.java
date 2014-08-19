/**
 * https://oj.leetcode.com/problems/multiply-strings/
 * 
 * @author yishen
 * 
 */
public class MultiplyStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MultiplyStrings instance = new MultiplyStrings();
        System.out.println(instance.multiply("1468488", "16489494189189"));
        // System.out.println((char)(3+'0'));

    }

    private StringBuilder sb = new StringBuilder();

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }

        String[] temp = new String[10];
        temp[0] = "0";
        for (int i = 1; i <= 9; i++) {
            temp[i] = add(num1, temp[i - 1]);
        }

        String result = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            // System.out.println(shift(temp[num2.charAt(i) - '0'], num2.length() - 1 - i));
            result = add(result, shift(temp[num2.charAt(i) - '0'], num2.length() - 1 - i));
        }

        return result;
    }

    public String shift(String s, int n) {
        StringBuilder ss = new StringBuilder(s);
        for (int i = 1; i <= n; i++) {
            ss.append('0');
        }
        return ss.toString();
    }

    public String add(String s1, String s2) {
        sb.setLength(0);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int result = s1.charAt(i) + s2.charAt(j) - '0' - '0' + carry;
            // System.out.println(result);
            if (result >= 10) {
                sb.append((char) (result - 10 + '0'));
                carry = 1;
            } else {
                sb.append((char) (result + '0'));
                carry = 0;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            char digit = s1.charAt(i);
            if (carry == 0) {
                sb.append(digit);
            } else if ('9' == digit) {
                sb.append('0');
                carry = 1;
            } else {
                sb.append((char) (digit + 1));
                carry = 0;
            }
            i--;
        }
        while (j >= 0) {
            char digit = s2.charAt(j);
            if (carry == 0) {
                sb.append(digit);
            } else if ('9' == digit) {
                sb.append('0');
                carry = 1;
            } else {
                sb.append((char) (digit + 1));
                carry = 0;
            }
            j--;
        }
        if (carry != 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
