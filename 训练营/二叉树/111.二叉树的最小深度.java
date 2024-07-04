//111.二叉树的最小深度     根节点到最近叶子节点的最短路径上的节点数量。

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

//1. 递归  要考虑左子树或者右子树为null的情况！    因为必须要找到叶子节点才能计算。
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int leftDepth  = minDepth(root.left);
        int rightDepth  = minDepth(root.right);
        if(root.left==null && root.right!=null) return rightDepth+1;
        else if(root.left!=null && root.right==null) return leftDepth+1;
        else return Math.min(leftDepth,rightDepth) + 1;
    }
}

//2.队列 迭代
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); //每次重新统计队列大小size
            depth++;
            for(int i=0; i<size ;i++){
                TreeNode node = queue.poll();
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if(node.left==null && node.right==null) return depth;

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }   
        return depth;// 理论上不会执行到这里
    }
}