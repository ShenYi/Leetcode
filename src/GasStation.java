/**
 * https://oj.leetcode.com/problems/gas-station/
 * 
 * @author yishen
 * 
 */
public class GasStation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new GasStation().canCompleteCircuit(new int[] {1, 2}, new int[] {2, 1}));

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int currentGas = gas[i];
            for (int j = i + 1; j < gas.length; j++) {
                currentGas -= cost[j - 1];
                if (currentGas < 0) {
                    break;
                }
                currentGas += gas[j];
            }
            if (currentGas < 0) {
                continue;
            }
            for (int j = 0; j <= i; j++) {
                currentGas -= cost[(j - 1 + cost.length) % cost.length];
                if (currentGas < 0) {
                    break;
                }
                currentGas += gas[j];
            }
            if (currentGas >= 0) {
                return i;
            }
        }
        return -1;
    }
}
