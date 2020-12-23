/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */
/**
 * 改进版二分查找
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

        while (right >= left) {
            //先找到数组的中间位置
            int mid = left + (right - left) / 2;
            //如果nums[mid] > nums[mid+1],则成功
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

