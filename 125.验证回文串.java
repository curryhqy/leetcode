/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        String newS = sb.toString();
        //双指针
        int n = sb.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(newS.charAt(left)) != 
                Character.toLowerCase(newS.charAt(right))) {
                    return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
// @lc code=end

