import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */
import java.util.List;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        //二叉搜索树的中序遍历一定升序
        List<Integer> ans = new ArrayList<>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                //左子树最右边节点
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                    continue;
                } else {
                    ans.add(root.val);
                    predecessor.right = null;
                }
            } else {
                ans.add(root.val);
            }
            root = root.right;
        }
        for (int i = 0; i < ans.size() - 1; i++) {
            int temp = ans.get(i);
            if (temp >= ans.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

