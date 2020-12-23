import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer,Integer> countAB = new HashMap<>();
        for (int x : A){
            for (int y : B){
                countAB.put(x + y, countAB.getOrDefault(x + y, 0) + 1);
            }
        }
        for (int x : C) {
            for (int y : D) {
                int tmp = -x-y;
                if (countAB.containsKey(tmp)){
                    ans += countAB.get(tmp);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

