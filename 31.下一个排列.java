/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */
/**
 * 下一个排列总是会比上一个排列大，除非该排列已经是最大的排列
 * 我们找到一个比当前排列大的一个新序列，且变化的幅度尽可能小
 * 1：将左边的一个较小数与右边的一个较大数交换，让当前排列变大
 * 2:同时要让这个较小数尽量靠右，较大数尽可能小
 * 3:交换完成后，这个较大数右边的数需要重新按照升序排列
 */
// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到较小数的位置i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //找到较大数的位置j
        if(i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// @lc code=end

