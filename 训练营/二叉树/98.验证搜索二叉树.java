//98.验证搜索二叉树

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

//1. 递归    前序遍历   利用搜索树特性
class Solution {
    //定义边界，比较大小
    private boolean validBST(TreeNode root, long lower, long upper) {
        if(root==null) return true;
        if(root.val<=lower || root.val>=upper){
            return false;
        }

        boolean leftBST= validBST(root.left,lower,root.val);//左边的都比我小
        boolean rightBST = validBST(root.right,root.val,upper);//右边的都比我大

        return leftBST && rightBST;
    }
    public boolean isValidBST(TreeNode root) {
        return validBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
}