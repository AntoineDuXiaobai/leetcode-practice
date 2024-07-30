//40.组合总和2    跳过同一树层使用过的元素

//1. 递归    回溯       
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
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
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if(i>startIndex &&candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,target,i+1,sum);   
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}

//2.剪枝优化
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }
    private void backtracking(int[] candidates,int target,int startIndex, int sum){
        //if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex; i<candidates.length && sum + candidates[i] <= target; i++){
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if(i>startIndex &&candidates[i]==candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,target,i+1,sum);   
            sum-=candidates[i];
            path.remove(path.size()-1);
        }
    }
}