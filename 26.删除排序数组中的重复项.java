/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int num : nums) {
            if (num > nums[i-1]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}
// @lc code=end

