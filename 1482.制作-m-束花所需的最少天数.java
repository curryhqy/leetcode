import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1482 lang=java
 *
 * [1482] 制作 m 束花所需的最少天数
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        while (low < high) {
            int days = (high + low) >> 1;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days+1;
            }
        }
        return low;
    }

    private boolean canMake(int[] bloomDay, int days, int m, int k) {
        int length = bloomDay.length;
        int bouquets = 0;
        int flower = 0;
        for (int i = 0; i < length && bouquets < m; i++) {
            if (bloomDay[i] <= days) {
                flower++;
                if (flower == k) {
                    bouquets++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }
        return bouquets >= m;
    }

}
// @lc code=end

