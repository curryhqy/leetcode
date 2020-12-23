import java.util.LinkedList;

/**
 * 剑指offer刷题
 */
/**
 * 机器人移动
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        //移动方向：向右、向下
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        int ans = 1;
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        Query<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[] {tx, ty});
                vis[tx][ty] = true;
                ans ++;
            }
        }
        return ans;
    }
    /**
     * 
     * @param x
     * @return 数位
     */
    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
             x /= 10;
        }
        return res;
    }
}