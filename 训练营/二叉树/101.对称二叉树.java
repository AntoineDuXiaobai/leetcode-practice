//101.对称二叉树

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

//1.  双端队列 迭代   这里不是层序遍历，对称的比较       offer>add
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        //BFS 借助队列
        Deque<TreeNode> deque = new LinkedList<>(); //queue里存的是树节点
        deque.add(root.left);
        deque.add(root.right);
        while(!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if(leftNode==null && rightNode==null) continue;  //都为null  直接判断下一组对称节点
            if(leftNode==null && rightNode!=null) return false;
            if(leftNode!=null && rightNode==null) return false;
            if(leftNode.val != rightNode.val) return false;
            deque.addFirst(leftNode.left); // 从队列头部加入
            deque.addFirst(leftNode.right);
            deque.addLast(rightNode.right);// 从队列尾部加入
            deque.addLast(rightNode.left);
        } 
        return true;
    }
}
//2.递归
class Solution {
    class Solution {
        private boolean compare(TreeNode leftNode, TreeNode rightNode){
            if(leftNode==null && rightNode==null) return true;
            if(leftNode==null && rightNode!=null) return false;
            if(leftNode!=null && rightNode==null) return false;
            if(leftNode.val != rightNode.val) return false;
            boolean compareOutside = compare(leftNode.left,rightNode.right);  //外层比较
            boolean compareInside = compare(leftNode.right,rightNode.left);   //内层比较
            return compareInside && compareOutside;     
        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null) return false;
            return compare(root.left,root.right);
        }
    }
}