/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */
/**
 * 假设从x只能到加油站y，则从x,y之间的任意一个加油站出发都不能到达y。
 * 算法思路：首先检查第0个加油站，并判断能不能围绕一周，
 * 如果不能，就从第一个无法到达的加油站开始继续检查。
 */
// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumGas = 0, sumCost = 0, cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumGas += gas[j];
                sumCost += cost[j];
                if(sumCost > sumGas){
                    break;
                }
                cnt++;
            }
            if(cnt == n) {
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

