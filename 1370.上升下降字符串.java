/*
 * @lc app=leetcode.cn id=1370 lang=java
 *
 * [1370] 上升下降字符串
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
         StringBuffer ans = new StringBuffer();
         while (ans.length() < s.length()) {
             for (int i = 0; i < 26; i++) {
                 if (nums[i] > 0) {
                     ans.append((char)(i + 'a'));
                     nums[i]--;
                 }
             }
             for (int i = 25; i >= 0; i--) {
                 if (nums[i] > 0) {
                     ans.append((char)(i + 'a'));
                     nums[i]--;
                 }
             }
         }
         return ans.toString();
    }
}
// @lc code=end

