/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    //俩俩比较
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            ans = longestCommonPrefix(ans, strs[i]);
            if (ans.length() == 0) {
                return "";
            }
        }
        return ans;
    }

    //两个字符串的最长公共前缀
    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index ++;
        }
        return str1.substring(0, index);
    }
}
// @lc code=end

