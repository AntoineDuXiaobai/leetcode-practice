//1.两数之和

//1. 哈希表   O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        //只需要遍历，插入一次           //值是key，索引是value
        for(int i=0;i<nums.length;i++){
            if(numMap.containsKey(target-nums[i])){    //如果哈希表中已经有target-num[i],直接返回
                return new int[]{numMap.get(target-nums[i]),i};   //返回索引
            }
            //没有合适的就插入
            numMap.put(nums[i],i);
        }
          
        return null;
    }
}



//2.暴力美学
class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
