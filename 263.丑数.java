/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        for (int i = 2; i < 6 && n != 0; i++) {
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
// @lc code=end

