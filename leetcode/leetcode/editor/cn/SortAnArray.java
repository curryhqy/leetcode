package editor.cn;

import java.util.Arrays;
import java.util.Random;

public class SortAnArray{
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{2, 5, 1, 3, 6, 7, 9})));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //快排，随机选取主元
    public int[] sortArray(int[] nums) {
        randomQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private void randomQuicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomPartition(nums, left, right);
            randomQuicksort(nums, left, pos - 1);
            randomQuicksort(nums, pos + 1, right);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, random, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        int j = right;
        while (i < j) {
            while (nums[i] <= pivot && i < j) {
                i++;
            }
            while (nums[j] >= pivot && i < j) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}