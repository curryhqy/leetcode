import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxNum = new int[len];
        int[] minNum = new int[len];
        System.arraycopy(nums, 0, maxNum, 0, len);
        System.arraycopy(nums, 0, minNum, 0, len);
        maxNum[0] = minNum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int max = maxNum[i-1] * nums[i];
            int min = minNum[i-1] * nums[i];
            maxNum[i] = Math.max(max, Math.max(nums[i], min));
            minNum[i] = Math.min(min, Math.min(max, nums[i]));
        }

        return Arrays.stream(maxNum).max().getAsInt();
    }
}
// @lc code=end

