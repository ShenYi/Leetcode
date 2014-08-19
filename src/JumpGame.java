import java.util.LinkedList;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/jump-game/
 * 
 * @author yishen
 * 
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(canJump2(a));
        System.out.println(canJump2(new int[] {1, 0, 2}));
    }

    public static boolean canJump(int[] A) {
        if (A != null && A.length != 0) {
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(0);
            while (!queue.isEmpty()) {
                int i = queue.poll();
                if (i == A.length - 1) {
                    return true;
                }
                int step = A[i];
                if (step != 0) {
                    step = step > A.length - 1 - i ? A.length - 1 - i : step;
                    for (int j = step; j > 0; j--) {
                        queue.add(i + j);
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static boolean canJump2(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int maxStep = 1;
        for (int i = 0; i < A.length; i++) {
            maxStep = (maxStep - 1) > A[i] ? (maxStep - 1) : A[i];
            if (i + maxStep >= A.length - 1) {
                return true;
            }
            if (maxStep == 0) {
                return false;
            }
        }
        return false;
    }
}
