/**
 * https://oj.leetcode.com/problems/powx-n/
 * 
 * @author yishen
 * 
 */
public class Pow {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // System.out.println(-(-2147483648));
        System.out.println(new Pow().pow(1.00000, -2147483648));
    }

    public double pow(double x, int n) {
        System.out.println(x + " " + n);
        if (n < 0) {
            /**
             * if n is minimal negative number
             * -n == n
             * use x^n=x^(n-1)*x^1
             */
            return 1 / (pow(x, -1 - n) * pow(x, 1));
        }

        double result = 1.0;
        double temp = x;
        int k = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & (k << i)) != 0) {
                result *= temp;
            }
            temp = temp * temp;
        }
        return result;
    }
}
