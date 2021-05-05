import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0)+1);
            }

        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry :cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}
// @lc code=end

