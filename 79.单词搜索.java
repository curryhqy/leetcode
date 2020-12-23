/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, word, visited, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 
     * @param board
     * @param word
     * @param visited 标记是否访问过
     * @param i,j 开始搜索的位置
     * @param k word[k]:字符串word从第k个字符开始第后缀字符
     * @return
     */
    public boolean check(char[][] board, String word, boolean[][] visited,
                        int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        int [][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] d : dir) {
            int newi = i + d[0], newj = j + d[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, word, visited, newi, newj, k+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
// @lc code=end

