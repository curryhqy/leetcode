/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int non = 0;
        int has = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            non = Math.max(non, has + prices[i] - fee);
            has = Math.max(has, non - prices[i]);
        }
        return non;
    }
}
// @lc code=end

