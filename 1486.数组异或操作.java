/*
 * @lc app=leetcode.cn id=1486 lang=java
 *
 * [1486] 数组异或操作
 */

// @lc code=start
class Solution {
    public int xorOperation(int n, int start) {

        int ans = 0;
        int cur = 0;

        for (int i = 0; i < n; i++) {
            cur = start + 2*i;
            ans ^= cur;
        }

        return ans;
    }
}
// @lc code=end

