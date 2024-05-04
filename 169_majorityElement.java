//169.多数元素

//1.  暴力法  时间复杂度O(n^2)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
       for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
               if(nums[j]==nums[i]){
                   count++;
                   if(count>nums.length/2){
                       return nums[j];
                   }
               }
           }
           count = 0;
       }
       return 0;
    }
}
//2. 哈希表储存   key:数字 value:出现次数 时间复杂度O(n) 空间复杂度O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int n = nums.length;
        for(int num : nums){
            if(countMap.containsKey(num)){//存在 就把value+1
                countMap.put(num,countMap.get(num)+1);
            }else{
                countMap.put(num,1);//不存在  就把他添加进哈希表
            }
            if(countMap.get(num)>n/2){
                return num;
            }
        }
        return -1;
    }
}

//3. 摩尔投票算法（Boyer-Moore Voting Algorithm）对抗和相消。  
//不一样就同归于尽。 count--    最后剩下的肯定是超过半数的。（正负电子）  时间复杂度O(n) 空间复杂度O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidate = 0;
        for(int num : nums){
            if(count==0){
                candidate = num;
                count = 1;
            } else if(candidate!=num){
                count--;
            }else{
                count++;
            }
        }
        return candidate;
    }
}