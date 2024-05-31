//283. 移动0

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        int index = 0;
        //index指针记录非0的元素，直接覆盖原始值，反正后面的都是补0
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
         //将后面的元素补0即可
        while(index<nums.length){
        for(int i=index; i<nums.length;i++){
            nums[i] = 0;
        }
    }
}


