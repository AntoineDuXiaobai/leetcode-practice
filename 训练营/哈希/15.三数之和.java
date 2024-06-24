//15.三数之和

//1. 双指针，  while判断
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //先排序
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0) return res;    //第一个已经大于0了，结束了
            if(i>0 && nums[i]==nums[i-1]) continue; //去重a
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0) right--;
                else if(sum<0) left++;
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //找到一个三元组后，去重b c
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;
                    right--; 
                    left++;       
                }
            }
        }
        return res;
    }
}

