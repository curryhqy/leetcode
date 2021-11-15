package editor.cn;

import java.util.Arrays;

public class RangeAdditionIi{
    public static void main(String[] args) {
        Solution solution = new RangeAdditionIi().new Solution();
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(solution.maxCount(3, 3, ops));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m, minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}