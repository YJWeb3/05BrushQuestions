package com.wclass.structalgorithm.sort_14.leetcode_nowcoder.d46_buy_sell_stocks_transaction_fees;

/**
 * @program: StructAlgorithm
 * @ClassName DynamicProgrammingS14D46
 * @description:
 * @author: W哥
 * @create: 2024-09-22-18-18
 * @Version 1.0
 **/
public class DynamicProgrammingS14D46 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit02(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
