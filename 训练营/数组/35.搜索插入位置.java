//35.搜索插入位置

//1. 二分查找
//左闭右闭
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]==target){   //正好等于的情况
                return mid;
            }else if(nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //剩余三种情况。 最左边，最右边，插入   其实都是left 或者 right + 1
        return left;
    }
}
