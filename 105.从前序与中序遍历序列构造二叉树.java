import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    /**
     * 健表示元素节点的值，值表示元素在中序遍历中出现的位置
     **/
    private Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int pre_root = preLeft;
        //在中序遍历中定位根节点
        int in_root = indexMap.get(preorder[pre_root]);
        
        //先建立根节点
        TreeNode root = new TreeNode(preorder[pre_root]);
        //得到左子树节点数目
        int size_left = in_root - inLeft;
        //递归构造左子树
        root.left = myBuildTree(preorder, inorder, preLeft+1, preLeft+size_left, inLeft, in_root-1);
        //递归构造右子树
        root.right = myBuildTree(preorder, inorder, preLeft+1+size_left, preRight, in_root+1, inRight);
        return root;
    }
}
// @lc code=end

