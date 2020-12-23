/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            ans[index++] = num;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = (i + k) % nums.length;
            nums[j] = ans[i];
        }
    }
}
// @lc code=end

