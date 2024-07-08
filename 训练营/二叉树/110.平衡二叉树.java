//110.平衡二叉树    二叉树每个节点  左右子树高度绝对值差 小于1

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

//1. 递归      O(n^2)
class Solution {
    private int getHeight(TreeNode root){
        if(root==null) return 0;
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        //判断平衡二叉树   不仅需要检查左右子树的高度差，还需要确保左右子树自身也是平衡的。
        if(Math.abs(leftHeight-rightHeight) <=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else{
            return false;
        }
    }
}
//2. 优化 避免重复计算   O(n)
class Solution {
     public boolean isBalanced(TreeNode root) {
         return getHeight(root) != -1;
     }
 
     private int getHeight(TreeNode root) {
         if (root == null) {
             return 0;
         }
         int leftHeight = getHeight(root.left);
         if (leftHeight == -1) {
             return -1;        // 左子树不平衡
         }
         int rightHeight = getHeight(root.right);
         if (rightHeight == -1) {
             return -1;      // 右子树不平衡
         }
         // 左右子树高度差大于1，return -1表示已经不是平衡树了
         if (Math.abs(leftHeight - rightHeight) > 1) {
             return -1;        // 当前节点不平衡
         }
         return Math.max(leftHeight, rightHeight) + 1;
     }
 }
 