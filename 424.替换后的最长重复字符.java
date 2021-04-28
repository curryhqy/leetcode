/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] str = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int res = 0;
        int[] fre = new int[26];
        while (right < len) {
            fre[str[right] - 'A']++;
            maxCount = Math.max(maxCount, fre[str[right] - 'A']);
            right++;
            if (right - left > maxCount + k) {
                fre[str[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
// @lc code=end

