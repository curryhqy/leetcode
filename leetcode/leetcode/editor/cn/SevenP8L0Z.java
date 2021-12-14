package editor.cn;

import java.util.*;

public class SevenP8L0Z{
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        dfs(res, path, vis, nums, set);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, boolean[] vis, int[] nums, Set<List<Integer>> set) {
        if (path.size() == nums.length) {
            List<Integer> x = new ArrayList<>(path);
           if (!set.contains(x)) {
               res.add(x);
               set.add(x);
           }
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            dfs(res, path, vis, nums, set);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}