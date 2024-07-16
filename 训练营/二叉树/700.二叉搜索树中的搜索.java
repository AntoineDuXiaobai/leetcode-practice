//700.二叉搜索树中的搜索

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

//1. 递归    前序遍历   利用搜索树特性！
class Solution {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            //终止条件
            if(root==null) return null;
            
            if(root.val == val) return root;
    
            if(root.val<val){
                return searchBST(root.right, val);
            }else{
                return searchBST(root.left, val);  
            }
        }
    }
}