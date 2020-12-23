/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        //如果n小于0，把它改为正数，并且把1/x提取出来一个
        if (n < 0)
            return 1 / x * myPow(1 / x, -n - 1);
        
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
// @lc code=end

