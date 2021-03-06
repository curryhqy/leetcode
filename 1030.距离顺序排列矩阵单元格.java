import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1030 lang=java
 *
 * [1030] 距离顺序排列矩阵单元格
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        //每个距离一个桶
        for (int i = 0; i <= maxDist; i++){
            bucket.add(new ArrayList<int[]>());
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i,j});
            }
        }

        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist (int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
// @lc code=end

