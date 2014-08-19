import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/two-sum/
 *
 * @author yishen
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] i1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(i1, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            Integer index = temp.get(target - num);
            if (index != null) {
                return new int[] {index + 1, i + 1};
            }
            temp.put(numbers[i], i);
        }
        return null;
    }
}
