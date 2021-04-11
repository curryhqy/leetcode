/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            int b = (n & 1);
            int c = (b << 31-i);
            res |= c;
            n = (n >> 1);
        }
        return res;
    }
}
// @lc code=end

