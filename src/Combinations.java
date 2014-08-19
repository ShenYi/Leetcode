import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combinations/
 * 
 * @author yishen
 * 
 */
public class Combinations {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Combinations().combine(100, 2));
    }

    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || k > n) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n - k + 1; i++) {
            List<List<Integer>> left = combine(n - i, k - 1);
            if (left != null) {
                for (List<Integer> rt : left) {
                    List<Integer> t = new ArrayList<Integer>();
                    t.add(i);
                    for (int a : rt) {
                        t.add(a + i);
                    }
                    result.add(t);
                }
            } else {
                List<Integer> t = new ArrayList<Integer>();
                t.add(i);
                result.add(t);
            }
        }

        return result;

    }
}
