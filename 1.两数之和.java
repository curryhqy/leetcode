import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int des = target - nums[j];
            if (map.containsKey(des) && j != map.get(des)) {
                return new int[]{j, map.get(des)};
            }
        }
        return new int[]{-1, -1};
    }
}
// @lc code=end

