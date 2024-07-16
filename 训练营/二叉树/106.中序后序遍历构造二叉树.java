//106.中序后序遍历构造二叉树

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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 用map保存中序序列的数值对应位置
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd){
        if (inBegin >= inEnd || postBegin >= postEnd) { //不满足左闭右开，没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd-1]);//通过后序最后一个值，找到根节点的值，再找到根节点在中序序列中的index
        TreeNode root = new TreeNode(inorder[rootIndex]);//构造节点
        int lenOfleft = rootIndex-inBegin;//中序左子树个数，根据长度切片
        root.left = findNode(inorder,inBegin,rootIndex,postorder,postBegin,postBegin+lenOfleft);
        root.right = findNode(inorder,rootIndex+1,inEnd,postorder,postBegin+lenOfleft,postEnd-1);
        return root;
    }
}