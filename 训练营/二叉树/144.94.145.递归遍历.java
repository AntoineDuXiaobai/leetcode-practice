//144.94.145.  递归遍历

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
//1. 递归 前序遍历  中-左-右
class Solution {
    private void preorder(TreeNode root, List<Integer> res){
        //终止条件
        if(root==null) return;
        //前序: 中左右
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
}
//2. 中序遍历   左-中-右
class Solution {
    private void inorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }
}
//3. 后序遍历  左-右-中
class Solution {
    private void postorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
}