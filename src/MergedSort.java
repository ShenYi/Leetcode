import java.util.Arrays;

/**
 * http://oj.leetcode.com/submissions/detail/6568592/
 * 
 * @author yishen
 *
 */
public class MergedSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[1];

        System.out.println(Arrays.toString(a));
    }

    @SuppressWarnings("unused")
    public static void merge(int A[], int m, int B[], int n) {
        if (A == null || B == null || m < 0 || n < 0 || A.length < m + n) {
            return;
        }

        int i = m - 1;
        int j = n - 1;

        int k = A.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (i >= 0) {
            A[k--] = A[i--];
        }

        while (j >= 0) {
            A[k--] = B[j--];
        }

        int s = 0;
        while (k < A.length - 1) {
            A[s++] = A[++k];
        }
        k = A.length - 1;
        while (k >= m + n) {
            A[k--] = 0;
        }
    }
}
