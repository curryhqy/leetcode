/*
 * @lc app=leetcode.cn id=1310 lang=java
 *
 * [1310] 子数组异或查询
 */

// @lc code=start
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            int x = 0;
            for (int j = from; j <= to; j++) {
                x ^= arr[j];
            }
            ans[i] = x;
        }
        return ans;
    }
}
// @lc code=end

