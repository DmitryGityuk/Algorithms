package tasks.LeetCode.array;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit)
                    profit = prices[j] - prices[i];
            }
            set.add(profit);
            profit = 0;
        }
        return Collections.max(set);
    }
}
