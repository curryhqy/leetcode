/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        //如果数组没有被旋转过
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < nums[right]) {
                right = pivot;
            } else if (nums[pivot] > nums[right]) {
                left = pivot + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
// @lc code=end

