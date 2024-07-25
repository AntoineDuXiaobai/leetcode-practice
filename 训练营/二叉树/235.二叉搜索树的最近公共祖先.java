//236.二叉树的最近公共祖先

//从下向上遍历，只能通过后序（回溯），左右中
//从根节点开始递归地搜索指定的两个节点(p 和 q)。   如果当前节点等于 p 或 q 中的一个，那么这个节点就可能是公共祖先。
//如果 p 和 q 分别位于当前节点的两侧（一个在左子树，另一个在右子树），那么当前节点就是它们的最近公共祖先。如果它们都在左子树或都在右子树，那么公共祖先也会在那一侧。

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

//1. 递归    根据root.val大小  判断p q在哪
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root.val>p.val && root.val>q.val){
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            if(left!=null) return left;
        }
        if(root.val<p.val && root.val<q.val){
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            if(right!=null) return right;
        }
        return root;

    }
}

//2.迭代
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val && root.val>q.val){
                root = root.left;
            }else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }else{
                return root;
            }           
        }
        return root;
    }
}