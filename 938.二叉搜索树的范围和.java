import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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

    int i = 0;
    int j = 0;
    int index = -1;
    public int rangeSumBST(TreeNode root, int low, int high) {
        //二叉搜索树的中序遍历一定有序
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list, low, high);
        
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += list.get(k);
        }

        return sum;
    }

    public void inorder(TreeNode root, List<Integer> res, int low, int high) {
        if (root == null) {
            return;
        }
        inorder(root.left, res, low, high);
        res.add(root.val);
        index++;
        if (root.val == low) {
            i = index;
        }
        if (root.val == high) {
            j = index;
        }
        inorder(root.right, res, low, high);
    }
}
// @lc code=end

