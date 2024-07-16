//654.最大二叉树

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
    public TreeNode constructHelper(int nums[], int leftIndex, int rightIndex){
        //递归 前序 中左右
        //终止条件
        if(rightIndex-leftIndex==0) return null;
        //if(rightIndex-leftIndex==1) return new TreeNode(nums[leftIndex]);

        int maxValue = nums[leftIndex];
        int maxIndex = leftIndex;
        for(int i=leftIndex+1; i<rightIndex; i++){
            if(nums[i]>maxValue){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        //dfs
        TreeNode root = new TreeNode(maxValue);
        root.left = constructHelper(nums,leftIndex,maxIndex);
        root.right = constructHelper(nums,maxIndex+1,rightIndex);

        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructHelper(nums, 0, nums.length);
    }
}