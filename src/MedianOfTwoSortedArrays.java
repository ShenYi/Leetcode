import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 4, 5, 6, 8, 11};
        int[] B = {1, 3, 9, 15, 17, 21};

        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(A, B));

    }

    public double findMedianSortedArrays(int A[], int B[]) {
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(" ");
        if (A.length == 1 && B.length == 1) {
            return (A[0] + B[0]) / 2;
        }
        int mid1 = A[A.length / 2];
        int mid2 = B[B.length / 2];

        if (mid1 == mid2) {
            return mid1;
        } else if (mid1 > mid2) {
            return findMedianSortedArrays(Arrays.copyOf(A, A.length / 2 + 1), Arrays.copyOfRange(B, B.length / 2, B.length));
        } else {
            return findMedianSortedArrays(Arrays.copyOfRange(A, A.length / 2, A.length), Arrays.copyOf(B, B.length / 2 + 1));
        }
    }

}
