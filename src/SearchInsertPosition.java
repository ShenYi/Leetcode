/**
 * https://oj.leetcode.com/problems/search-insert-position/
 *
 * @author yishen
 *
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] i1 = {1, 3, 5, 6, 12};
        System.out.println(searchInsertBinary(i1, 5));
        System.out.println(searchInsertBinary(i1, 2));
        System.out.println(searchInsertBinary(i1, 4));
        System.out.println(searchInsertBinary(i1, 0));
    }

    public int searchInsert(int[] A, int target) {
        if (A == null) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                return i;
            }
        }

        return A.length;
    }

    public static int searchInsertBinary(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int low = 0;
        int hi = A.length - 1;
        int mid;
        while (low <= hi) {
            mid = (hi - low) / 2 + low;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
