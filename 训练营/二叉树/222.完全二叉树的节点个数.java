//222.完全二叉树的节点个数

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

//1. 递归    O(n)
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int countLeftNode = countNodes(root.left);
        int countRightNode = countNodes(root.right);
        return countLeftNode + countRightNode + 1;
    }
}

//2.队列 迭代
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
                count++;//计数要在每次循环内部！
            }           
        }
        return count;
    }
}
//3. 按照完全二叉树的特性  2^h-1    递归   
class Solution {
    /**
     * 针对完全二叉树的解法
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0; // 这里初始为0是有目的的，为了下面求指数方便
        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }
        //计算左右节点时，可以少遍历几个节点，但也是O(n)
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
