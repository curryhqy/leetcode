package editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ans.add(Arrays.stream(new int[] {nums[i], nums[left], nums[right]}).boxed().collect(Collectors.toList()));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}