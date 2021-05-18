/*
 * @lc app=leetcode.cn id=1442 lang=java
 *
 * [1442] 形成两个异或相等数组的三元组数目
 */

// @lc code=start
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        var s = new int[n+1];
        for (var i = 1; i <= n; i++) {
            s[i] = s[i-1] ^ arr[i-1];
        }
        var ans = 0;
        for (var i = 0; i < n; i++) {
            for (int k = i+1; k < n; k++) {
                if (s[i] == s[k+1]) {
                    ans += k-i;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

