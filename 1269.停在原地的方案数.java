/*
 * @lc app=leetcode.cn id=1269 lang=java
 *
 * [1269] 停在原地的方案数
 */

// @lc code=start
class Solution {
    public int numWays(int steps, int arrLen) {
        final int mod = 1000000007;
        int column = Math.min(steps, arrLen - 1);

        //dp[i][j]表示i步后，位于j下标的方案数
        int[][] dp = new int[steps+1][column+1];
        dp[0][0] = 1;
        for (int j = 1; j <= column; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] += dp[i-1][j];
                if (j-1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod;
                }
                if (j+1 <= column) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % mod;
                }
            }
        }
        return dp[steps][0] % mod;
    }
}
// @lc code=end

