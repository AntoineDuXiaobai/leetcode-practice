//617.合并二叉树

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

//1. 递归    前序遍历
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //一个树为null，返回另一个
        if(root1==null) return root2;
        if(root2==null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);

        return root1;
    }
}

//2. 迭代 层序遍历    以root1为主，如果root1子节点null，root2子节点不null， 直接替换
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while(!queue.isEmpty()){
            //一次加入相同位置的两个节点，再取出，比较子节点
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            if(node1.left!=null&&node2.left!=null){
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            if(node1.right!=null&&node2.right!=null){
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            if(node1.left==null&&node2.left!=null){
                node1.left = node2.left;
            }
            if(node1.right==null&&node2.right!=null){
                node1.right = node2.right;
            }
        }
        return root1;
    }
}