import java.util.ArrayList;
import java.util.List;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        TreeNode p1 = root;
        TreeNode p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if(p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(ans, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(ans, root);
        return ans;
    }

    public void addPath(List<Integer> ans, TreeNode node) {
        int count = 0;
        while (node != null) {
            count ++;
            ans.add(node.val);
            node = node.right;
        }
        int left = ans.size() - count;
        int right = ans.size() - 1;
        while (left < right) {
            int temp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, temp);
            left ++;
            right --;
        }
    }
}
// @lc code=end

