/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        StringBuilder num = new StringBuilder();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            num.append(Integer.toString(i));
        }
        return num.charAt(n);
    }
}
// @lc code=end

