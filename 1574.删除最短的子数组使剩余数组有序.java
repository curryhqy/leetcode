/*
 * @lc app=leetcode.cn id=1574 lang=java
 *
 * [1574] 删除最短的子数组使剩余数组有序
 */

// @lc code=start
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int left = 0;
        while (left < len-1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        //[0,left]有序
        if (left == len - 1) {
            return 0;
        }

        //[right, n-1]有序
        int right = len - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int result = Math.min(len - left - 1 , right);

        int i = 0;
        int j = right;
        while (i <= left && j <= len - 1) {
            if (arr[i] <= arr[j]) {
                //[0, i],[j, n-1]有序,删除[i+1, j-1]
                result = Math.min(result, j-i-1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
// @lc code=end

