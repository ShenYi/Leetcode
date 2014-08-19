/**
 * https://oj.leetcode.com/problems/single-number/
 * 
 * @author yishen
 * 
 */
public class SingleNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(singleNumber(new int[] {1, 2, 3, 1, 3}));
    }

    public static int singleNumber(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        for (int aA : A) {
            start ^= aA;
        }

        return start;

    }
}
