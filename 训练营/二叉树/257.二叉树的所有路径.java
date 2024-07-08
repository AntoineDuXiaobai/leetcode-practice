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

//1. 递归 + 回溯      O(n^2)   dfs  前序遍历  中左右
class Solution {
    private void constructPaths(TreeNode root, StringBuilder path, List<String> res){
        if(root==null) return;
        // 记录进入这一层递归时的路径长度
        int len = path.length();
        path.append(Integer.toString(root.val));

        if(root.left==null&&root.right==null){
            //叶子节点，添加路径到res
            res.add(path.toString());
        }else{
            //非叶子节点，继续递归
            path.append("->");   
            constructPaths(root.left, path, res);
            constructPaths(root.right, path, res);
            }

        //回溯！！！  撤销对当前节点的添加，回到进入该节点前的状态
        path.setLength(len);

    }        
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root, new StringBuilder(), res);
        return res;
    }
}
//2.  String 代替 StringBuilder    隐式回溯
// 任何看似修改 String 的操作其实都是在创建一个新的 String 对象。
// 每次对 path 变量的修改实际上都是创建了一个新的字符串，并将其传递给递归调用。
// 这样，每个递归实例都有自己的 path 字符串版本，这与其父递归实例完全隔离。
class Solution {
    private void constructPaths(TreeNode root, String path, List<String> res){
        if(root==null) return;

        path += String.valueOf(root.val);

        if(root.left==null&&root.right==null){
            //叶子节点，添加路径到res
            res.add(path);
        }else{
            //非叶子节点，继续递归
            //path += "->";    也可
            constructPaths(root.left, path+"->", res);
            constructPaths(root.right, path+"->", res);
            }
    }        
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPaths(root, "", res);
        return res;
    }
}