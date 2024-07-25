//216.组合综合3
//update

//1. 递归    回溯        sum和path都要回溯
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return res;
    }
    void backtracking(int k, int n, int startIndex, int sum){
        //终止条件
        if(sum>n) return;
        if(path.size()==k){
            if(sum==n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        //剪枝
        for(int i=startIndex; i<=9-(k-path.size())+1; i++){
            path.add(i);
            sum+=i;
            backtracking(k,n,i+1,sum);
            sum-=i;
            path.remove(path.size()-1);
        }
    }
}
//2.  别的方法
class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        build(k, n, 1, 0);
        return res;
    }

    private void build(int k, int n, int startIndex, int sum) {

        if (sum > n) return;
        //替换上一种的剪枝
        if (path.size() > k) return;

        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            //sum += i;
            build(k, n, i + 1, sum+i);  //Java值传递
           // sum -= i;
            path.removeLast();
        }
    }
}