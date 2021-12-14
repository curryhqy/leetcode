package editor.cn;

import java.util.ArrayList;
import java.util.List;

public class VvJkup{
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(res, path, vis, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, boolean[] vis, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            dfs(res, path, vis, nums);
            vis[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}