import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int num : nums) {
            if (map.get(num) == 1) {
                ans[index++] = num;
            }
        }
        return ans;
    }
}
// @lc code=end

