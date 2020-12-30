/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }
        //背包 + 动态规划
        //当有i块石头时，包里的最大重量为j
        int[][] dp = new int[length + 1][total / 2 + 1];
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < total / 2 + 1; j++) {
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j-stones[i-1]]+stones[i-1],dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return total - (2 * dp[length][total / 2]);
    }
}
// @lc code=end

