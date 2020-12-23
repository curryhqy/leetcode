import java.util.*;
/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉K位数字
 */

/**
 * 移掉k位数字等于：
 * 1：移掉k-1位数字
 * 2：移掉1位数字
 */
// @lc code=start
class Solution {
    /**
     * 给定一个长度为n的数字序列：从左往右找到第一个位置i使得num[i]<num[i-1]
     * 删去num[i-1],如果不存在，说明数字序列单调不降，删去最后一个数即可。
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
// @lc code=end

