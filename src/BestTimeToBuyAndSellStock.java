/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author yishen
 * 
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int preMin = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - preMin > max) {
                max = prices[i] - preMin;
            }
            if (prices[i] < preMin) {
                preMin = prices[i];
            }
        }
        return max > 0 ? max : 0;
    }
}
