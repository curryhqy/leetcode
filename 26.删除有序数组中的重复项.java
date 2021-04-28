/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int index = 1;
        int point = 1;
        while (point != length) {
            if (nums[point] != nums[point-1]) {
                nums[index] = nums[point];
                index++;
            }
            point++;
        }
        return index;
    }
}
// @lc code=end

