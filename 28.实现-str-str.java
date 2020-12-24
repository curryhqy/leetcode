/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        //双指针
        int ph = 0;
        while (ph < h - n + 1) {
            //找到第一个匹配的字符
            while (ph < h - n + 1 && haystack.charAt(ph) != needle.charAt(0)) {
                ph ++;
            }
            //从后找
            int curr = 0, pn = 0;
            while (pn < n && ph < h && haystack.charAt(ph) == needle.charAt(pn)) {
                ph ++;
                curr ++;
                pn ++;
            }
            if (curr == n) {
                return ph - n;
            }
            ph = ph - curr + 1;
        }
        return -1;
    }
}
// @lc code=end

