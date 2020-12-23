/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /* int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            //dp[i][0]表示第i天交易完成后手里没有股票的最大利润
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            //dp[i][1]表示第i天交易完成后手里有股票的最大利润
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
        }
        return dp[n-1][0] > dp[n-1][1] ? dp[n-1][0] : dp[n-1][1]; */
        //压缩空间：每一天的状态只与前一天有关
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
}
// @lc code=end

