package editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 6));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        //小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            int topEle = pq.peek();
            if (topEle < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}