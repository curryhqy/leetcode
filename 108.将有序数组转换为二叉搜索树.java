/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length - 1);
    }
    //选择中间位置左边的数字作为根结点
    private TreeNode create(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums, left, mid - 1);
        root.right = create(nums, mid + 1, right);
        return root;
    }
}
// @lc code=end

