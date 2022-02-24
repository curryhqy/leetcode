package editor.cn;

public class WhereWillTheBallFall{
    public static void main(String[] args) {
        Solution solution = new WhereWillTheBallFall().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int col = i; //列
            for (int[] row : grid) {
                int dir = row[col];
                col += dir;
                if (col < 0 || col >= n || row[col] != dir) {
                    col = -1;
                    break;
                }
            }
            ans[i] = col;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}