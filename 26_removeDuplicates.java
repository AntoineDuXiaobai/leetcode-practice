//26.删除有序数组中的重复项 

//1.  快慢双指针   快指针遍历   慢指针逐个替换元素
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 1;
        while(fast<nums.length){
            if(nums[fast]!=nums[slow]){
                slow++;// 发现不一样，慢指针先往后移动一个，再替换！
                nums[slow] = nums[fast];
                
            }
            fast++;
        }
        return slow+1;   //元素数量=索引数+1
    }
}