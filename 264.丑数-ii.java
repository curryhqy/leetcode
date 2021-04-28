import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int[] factor = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        set.add(1L);
        priorityQueue.add(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = priorityQueue.poll();
            ugly = (int)cur;
            for (int factors : factor) {
                long next = cur * factors;
                if (!set.contains(next)) {
                    set.add(next);
                    priorityQueue.add(next);
                }
            }
        }
        return ugly;
    }
}
// @lc code=end

