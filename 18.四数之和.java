import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    /**
     * 
     * @param nums
     * @param target
     * @param k
     * @return 满足k数之和为target的多个数组
     */
    public ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        int len = nums.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (index >= len) {
            return ans;
        }
        if (k == 2) {
            //双指针
            int i = index;
            int j = len - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> temp =  new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    //避免重复数字
                    while(i<j && nums[i]==nums[i+1]) i++;
                    while(i<j && nums[j-1]==nums[j]) j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            //降维
            for (int i = index; i < len - k + 1; i++) {
                ArrayList<List<Integer>> temp = kSum(nums, target-nums[i], k-1, i+1);
                //把先前的结果加进去
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                    ans.addAll(temp);
                while (i < len-1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end