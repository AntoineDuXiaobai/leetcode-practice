//34.搜索第一个和最后一个位置

//1. 二分查找
class Solution {
    public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];
            res[0] = findFirstPos(nums,target);
            res[1] = findLastPos(nums,target);
            return res;
    }
    private int findFirstPos(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;  //找不到默认-1

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                pos = mid;
                right = mid - 1;  //因为要找第一个，所以继续往左找
            }else if(nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return pos;
    }
    private int findLastPos(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int pos = -1;//找不到默认-1

        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                pos = mid;
                left = mid + 1;  //因为找最后一个，所以继续往右找
            }else if(nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return pos;
    }
}