package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairsWithSumLcci{
    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (numList.get(left) + numList.get(right) == target) {
                res.add(Arrays.asList(numList.get(left), numList.get(right)));
                left++;
                right--;
            } else if (numList.get(left) + numList.get(right) < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}