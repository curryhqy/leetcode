import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
/**可以使用优先队列（大根堆）实时维护前k个最小的距离平方
 * 
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[0] - a[0];
            }
        });
        for (int i = 0; i < K; i++) {
            pq.offer(new int[] {points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        
        for (int i = K; i < points.length; i++) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if(dist < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[] {dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++){
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
// @lc code=end

