//18.四数之和

//1. 双指针，  while判断。   多加一层for循环
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //先排序
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0 && nums[i]>target) return res;    //剪枝操作，当i正数大于target，结束了
            if(i>0 && nums[i]==nums[i-1]) continue; //去重a  第一次之后

            //加一层for循环，j从i+1开始
            for(int j=i+1; j<nums.length; j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue; //去重b 第一次之后
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum>target) right--;
                    else if(sum<target) left++;
                    else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //找到一个三元组后，去重c d
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        right--; 
                        left++;   
                    }    
                }
            
            }
            
        }
        return res;
    }
}

//2.暴力美学 但超时
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> resp = new ArrayList<>();
      for(int i=0;i<nums.length;i++){
          for(int j=i+1;j<nums.length;j++){
              for(int k=j+1;k<nums.length;k++){
                  for(int l=k+1;l<nums.length;l++){
                      if(nums[i]+nums[j]+nums[k]+nums[l] == target){
                          List<Integer> ans = new ArrayList<>();
                          ans.add(nums[i]);
                          ans.add(nums[j]);
                          ans.add(nums[k]);
                          ans.add(nums[l]);
                          Collections.sort(ans);
                          if(!resp.contains(ans)){
                             resp.add(ans); 
                          }
                      }
                  }
              }
          }
      }
      return resp;
  }
}