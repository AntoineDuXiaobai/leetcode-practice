//39.组合总和

//1. 递归    回溯       
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    //int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target,0,0);
        return res;
    }
    private void backtracking(int[] candidates,int target,int startIndex, int sum){
        if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex; i<candidates.length; i++){
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,target,i,sum);   //index每次从i开始  关键
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}
//2.剪枝优化
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序  方便后面剪枝
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}