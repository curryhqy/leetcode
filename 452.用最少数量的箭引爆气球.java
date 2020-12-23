import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //按points右边界升序排列
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2) {
                return p1[1] > p2[1] ? 1 : -1;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

