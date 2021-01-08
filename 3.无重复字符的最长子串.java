import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int index = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            } 

            while (index + 1 < len && !set.contains(s.charAt(index + 1))) {
                set.add(s.charAt(index + 1));
                index ++;
            }
            ans = Math.max(ans, index - i + 1);
        }
        return ans;
    }
}
// @lc code=end

