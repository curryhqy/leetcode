package editor.cn;

public class NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int numOfLands = 0;
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    numOfLands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfLands;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}