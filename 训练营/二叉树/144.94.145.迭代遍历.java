//144.94.145.  迭代遍历

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
//1. 前序遍历顺序：中-左-右，入栈顺序：中-右-左
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        //先push进去第一个节点
        stack.push(root);
        //当stack非空
        while(!stack.isEmpty()){
            //先把node取出，值加入res   再判断要不要加入右左节点
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return res;
    }
}
//2. 中序遍历   左-中-右
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
           if (cur != null){
               stack.push(cur);
               cur = cur.left;
           }else{//左孩子是空，就把该node弹出来，加入res，再查看右孩子
               cur = stack.pop();
               result.add(cur.val);
               cur = cur.right;
           }
        }
        return result;
    }
}
//3. 后序遍历顺序 左-右-中    入栈顺序：中-左-右    实现出栈顺序：中-右-左， 最后翻转结果
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        //先push进去第一个节点
        stack.push(root);
        //当stack非空
        while(!stack.isEmpty()){
            //先把node取出，值加入res   再判断要不要加入左右节点
            TreeNode node = stack.pop();
            res.add(node.val);  
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);          
        }
        Collections.reverse(res);
        return res;
    }
}