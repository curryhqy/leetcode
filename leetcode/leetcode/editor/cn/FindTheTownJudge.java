package editor.cn;

public class FindTheTownJudge{
    public static void main(String[] args) {
        Solution solution = new FindTheTownJudge().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        //判断节点的 入度 出度
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] element : trust) {
            inDegrees[element[1]]++;
            outDegrees[element[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == n-1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}