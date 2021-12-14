import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述信息
 *
 * @author: curryhqy
 * @date: 2021-11-21 18:51
 **/
public class MiHoYo {
    public ArrayList<ArrayList<Integer>> permute (int[] nums) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] bl = new boolean[nums.length];
        dfs(nums, bl, path, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] bl, List<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!bl[i]) {
                path.add(nums[i]);
                bl[i] = true;
                dfs(nums, bl, path, res);
                bl[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    private void backtrack(int len, List<Integer> out, ArrayList<ArrayList<Integer>> res, int first) {
        if (first == len) {
            res.add(new ArrayList<>(out));
        }
        for (int i = first; i < len; i++) {
            Collections.swap(out, first, i);
            backtrack(len, out, res, first + 1);
            Collections.swap(out, first, i);
        }
    }
}
