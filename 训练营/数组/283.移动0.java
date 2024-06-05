//283.移动0

//1.快慢双指针。    先替换， 剩下的补0
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        int slow = 0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for(;slow<nums.length;slow++){
            nums[slow] = 0;
        }
        
    }
}
