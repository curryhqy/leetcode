import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1202 lang=java
 *
 * [1202] 交换字符串中的元素
 */

// @lc code=start
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        int length = s.length();

        int[] parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
        
        //合并
        for (List<Integer> list : pairs) {
            int ancestry0 = find(list.get(0), parent);
            int ancestry1 = find(list.get(1), parent);
            parent[ancestry0] = ancestry1;
        }

        Map<Integer, Queue<Character>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int ancestry = find(i, parent);
            map.computeIfAbsent(ancestry, k -> new PriorityQueue<>()).offer(s.charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Queue queue = map.get(find(i, parent));
            ans.append(queue.poll());
        }

        return ans.toString();

    }
    
    public int find (int i , int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }
}

// @lc code=end

