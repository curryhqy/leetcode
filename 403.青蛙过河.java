import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=403 lang=java
 *
 * [403] 青蛙过河
 */

// @lc code=start
class Solution {

    private Boolean[][] reached;

    public boolean canCross(int[] stones) {
        int len = stones.length;
        reached = new Boolean[len][len];
        return dfs (stones, 0, 0);
    }

    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            return true;
        }
        if (reached[i][lastDis] != null) {
            return reached[i][lastDis];
        }
        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i+1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return reached[i][lastDis] = true;
                }
            }
        }
        return reached[i][lastDis] = false;
    }

}
// @lc code=end

