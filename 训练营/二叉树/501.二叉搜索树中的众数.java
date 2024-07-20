//501.二叉搜索树中的众数

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

 // 中序遍历BST会按照数值递增顺序访问每个节点。
 // 因此，计算相邻节点的差值可以直接给出任意两节点间的最小差值。

//1. 递归    中序遍历   左中右       利用hashmap
class Solution {
    private Map<Integer,Integer> map = new HashMap<>();
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inOrder(root.right);
    }
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>(); 
        inOrder(root);
        int maxOccur = Integer.MIN_VALUE;
        for(int i: map.values()){
            if(i>maxOccur){
                maxOccur = i;
            }
        }
        //map.entrySet()方法     Map.Entry<I,I> entry 来遍历
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==maxOccur){
                res.add(entry.getKey());
            }
        }
        //List转换为int[]
        return res.stream().mapToInt(x->x).toArray();
    }
}
//2. 利用BST特性，比较相邻的节点 计数
class Solution {
    ArrayList<Integer> resList = new ArrayList<>();;
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        //List转换为int[]
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null)  return;
        inOrder(root.left);

        // 计数
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(root.val);
        }
        pre = root;

        inOrder(root.right);
    }
}