//112.路径总和

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

//1. 递归  
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        targetSum -= root.val;
         // 终止条件: 遇到叶子节点，检查当前计数是否为0（即路径和是否等于目标值）
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        
        if (root.left != null){
            if(hasPathSum(root.left, targetSum)){
                return true;
            }
        }  

       if (root.right != null){
            if(hasPathSum(root.right, targetSum)){
                return true;
            }
        } 
        // 如果左右子树都没有找到有效路径，返回false
        return false;
    }   
}
//2. 迭代 层序遍历     需要定义一个Pair
class Solution {
    public class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root,root.val));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair<TreeNode,Integer> pairNode = queue.poll();
                TreeNode curNode = pairNode.first;
                int curSum = pairNode.second;
                if(curNode.left==null&&curNode.right==null){
                    if(curSum==targetSum) return true;
                }
                if(curNode.left!=null) queue.offer(new Pair<>(curNode.left,curNode.left.val+curSum));
                if(curNode.right!=null) queue.offer(new Pair<>(curNode.right,curNode.right.val+curSum));
            }
        }
        return false;
    }   
}
//3. 迭代   需要两个队列queue
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueValue = new LinkedList<>();
        queueNode.offer(root);
        queueValue.offer(root.val);
        while(!queueNode.isEmpty()){
            int size = queueNode.size();
            for(int i=0; i<size; i++){
                TreeNode curNode = queueNode.poll();
                int curSum = queueValue.poll();
                if(curNode.left==null&&curNode.right==null){
                    if(curSum==targetSum) return true;
                }
                if(curNode.left!=null){
                    queueNode.offer(curNode.left);
                    queueValue.offer(curSum+curNode.left.val);
                }
                if(curNode.right!=null){
                    queueNode.offer(curNode.right);
                    queueValue.offer(curSum+curNode.right.val);
                }
            }
        }
        return false;
    }   
}