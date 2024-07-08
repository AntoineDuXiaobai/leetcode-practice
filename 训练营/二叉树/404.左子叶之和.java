//257.二叉树的所有路径

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

//1. 递归    dfs  后序遍历  左右中
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;

        int leftValue = sumOfLeftLeaves(root.left); //左
        int rightValue = sumOfLeftLeaves(root.right);//右

        int midValue = 0;
        if(root.left!=null && root.left.left==null && root.left.right==null){
            midValue = root.left.val;  //中   在中统计  如果左孩子是叶子
        }
        return midValue + leftValue + rightValue;

    }
}
//2. 迭代 层序遍历
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left!=null){ //由父节点来判断：左孩子是不是叶子
                    if(node.left.left==null && node.left.right==null){
                        sum+=node.left.val;
                    }
                    queue.offer(node.left);
                }
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return sum;
    }
}