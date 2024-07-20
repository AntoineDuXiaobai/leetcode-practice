//530.二叉搜索树最小绝对值差

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

 // 中序遍历BST会按照数值递增顺序访问每个节点。
 // 因此，计算相邻节点的差值可以直接给出任意两节点间的最小差值。

//1. 递归    中序遍历   左中右       BST
class Solution {
    class Solution {
        private TreeNode pre =null;
        private int minDiff = Integer.MAX_VALUE;

        private void inOrder(TreeNode root){
            if(root==null) return;
            inOrder(root.left);
            if(pre!=null){
                minDiff = Math.min(minDiff,Math.abs(root.val-pre.val));
            }
            pre = root;  //替换为中的节点
            inOrder(root.right);
        }

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minDiff;
        }
    }
}