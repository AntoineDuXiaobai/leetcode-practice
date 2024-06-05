//27.移除元素

//1. 快慢双指针  
class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0;  //快指针，筛选数组的每一值 
        int slow = 0;  //慢指针，指向新数组的每一个位置，用于构建新数组
        for(; fast<nums.length; fast++){
            if(nums[fast]!=val){   //不是val，就插入到新数组中
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;

    }
}