package editor.cn;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber{
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        int[] ints = new int[]{0, 1, 3};
        System.out.println(solution.missingNumber(ints));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= len; i++) {
            set.add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        return (int) set.toArray()[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}