/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
/**
 * dp[i][j][k]:0-i的区间里面,状态为j时的获利(j = 0,1)
 * j = 0:当前不持股
 * j = 1:当持股
 * k为交易次数
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        //初始化状态
        //第一天持有，则不管交易次数，都为-price[0]
        //第一天不持有，则不管交易次数，都为0
        dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = 0;
        dp[0][1][0] = dp[0][1][1] = dp[0][1][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][0]+prices[i]);
            dp[i][0][2] = Math.max(dp[i-1][0][2], dp[i-1][1][1]+prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][0][0]-prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][1]-prices[i]);
            dp[i][1][2] = 0;
        }
        return Math.max(dp[n-1][0][1], dp[n-1][0][2]);
    }
}
// @lc code=end

