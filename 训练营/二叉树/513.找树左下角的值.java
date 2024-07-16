//513.找树左下角的值

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

//1. 迭代    层序遍历  
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                //记录第n层，第一个值。  即最底层，最左边的值
                if(i==0){
                    res = node.val;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return res;
    }
}
//2. 迭代 层序遍历   优化
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node =null;  //设置为全局变量
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //按照先右后左的顺序进入queue。  那么最后一层，最左侧节点将最后一个进入。   返回最后一个node的val就行了
            for(int i=0;i<size;i++){
                node = queue.poll();
                if(node.right!=null) queue.offer(node.right);
                if(node.left!=null) queue.offer(node.left);   
            }
        }
        return node.val;
    }
}
//3. 递归
class Solution {
    private int maxDepth = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int depth) {
        if (root == null) return;
        //终止条件，找到叶子节点。 如果比maxDepth深，就记录value，并更新最大深度
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                value = root.val;
                maxDepth = depth;
            }
        }
        if (root.left != null) findLeftValue(root.left,depth + 1);   //dfs  中左右
        if (root.right != null) findLeftValue(root.right,depth + 1);
    }
}