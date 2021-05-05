import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除与获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();

        int[] arr = new int[maxVal + 1];
        for (int x : nums) {
            arr[x] += x;
        }
        return rob(arr);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}
// @lc code=end

