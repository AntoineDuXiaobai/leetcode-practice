//226.翻转二叉树

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

//1. 深度遍历    深度优先搜索DFS     递归。   这里前序后序都可以,中序不行
class Solution {
    private void swap(TreeNode root){
        if(root==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        //swap(root);
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }
}
//2. 层序遍历    深度优先搜索DFS   迭代。
class Solution {
    private void swap(TreeNode root){
        if(root==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        //BFS 借助队列
        Queue<TreeNode> queue = new LinkedList<>(); //queue里存的是树节点
        queue.add(root);
        while(!queue.isEmpty()){
            //注意需要for循环把queue里的节点都处理了   需要注意size！
            for(int i=0; i<queue.size(); i++){
               TreeNode cur = queue.poll();
               swap(cur);
               if(cur.left!=null) queue.add(cur.left);
               if(cur.right!=null) queue.add(cur.right); 
            }   
        } 
        
        return root;
    }
}