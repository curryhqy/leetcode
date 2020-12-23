/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int point0 = 0;
        int point = 0;
        while (point0 < nums.length && point < nums.length) {
            if (nums[point] != 0) {
                swap(nums, point, point0);
                point0++;
            }
            point++;
        }
    }

    public void swap(int []nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

