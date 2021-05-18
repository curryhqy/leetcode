/*
 * @lc app=leetcode.cn id=1720 lang=java
 *
 * [1720] 解码异或后的数组
 */

// @lc code=start
class Solution {
    public int[] decode(int[] encoded, int first) {
        int len = encoded.length + 1;
        int[] arr = new int[len];
        arr[0] = first;
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i-1] ^ encoded[i-1];
        }
        return arr;
    }
}
// @lc code=end

