//80. 删除排序数组中的重复项 II

//1.  快慢双指针   快指针遍历 
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length ==0){
            return 0;
        }
        if(nums.length<=2){     //长度小于2 肯定符合 
            return nums.length;
        }
        int slow = 2, fast = 2;   //从第三项开始检查
        while(fast<nums.length){
            if(nums[fast]!=nums[slow-2]){  // fast和slow前两个比不一样   说明数据不一样了
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
}
}