package editor.cn;

import java.util.List;

public class MaximumDepthOfNAryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
        
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int childDepth = maxDepth(child);
            max = Math.max(max, childDepth);
        }
        return max + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}