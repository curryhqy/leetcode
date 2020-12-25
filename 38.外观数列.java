/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        //递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        //拿到上一层的字符串
        String str = countAndSay(n - 1);
        int len = str.length();
        //指针读取字符串
        int start = 0;
        for (int i = 1; i < len + 1; i++) {
            if (i == len) {
                res.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(start)) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}
// @lc code=end

