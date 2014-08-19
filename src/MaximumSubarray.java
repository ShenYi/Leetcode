/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * @author yishen
 * 
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MaximumSubarray().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = A[0];
        int sum = A[0] > 0 ? A[0] : 0;
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

}
