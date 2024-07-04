//104.二叉树的最大深度        其实是求高度

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

//1. 递归  分别求左右子树最大高度，取max，再+1
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;  //递归截止条件
        int leftDepth  = maxDepth(root.left);
        int rightDepth  = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
}

//2.队列 迭代 计算高度
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); //每次重新统计队列大小size
            depth++;
            for(int i=0; i<size ;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }   
        return depth;
    }
}