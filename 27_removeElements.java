//27. 移除元素

//1.  快慢双指针   快指针遍历   慢指针比较
class Solution {
    public int removeElement(int[] nums, int val) {
            int slow = 0 , fast = 0;
            while(fast<nums.length){
                if(nums[fast]!=val){
                    nums[slow] = nums[fast];//如果不是想删除的值，就添加到数组中（重叠）
                    slow++;
                }
                fast++;
            }
            return slow;
    }
}