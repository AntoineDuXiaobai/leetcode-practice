//977.有序数组的平方

//1. 暴力美学     先平方，再用Arrays.sort(nums)排序
class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];   
        }
        Arrays.sort(nums);
        return nums;
    }
}


//2. 双指针  左右比较 （因为平方最大值肯定在最左或者最右出现）
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];   //建新数组保留原数组完整
        int left = 0;
        int right = nums.length-1;
        int k = nums.length-1;
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                res[k] = nums[left]*nums[left];  //比较左右两边哪个平方大，然后放进新数组最后面，再往前走
                k--;
                left++;
            }else{
                res[k] = nums[right]*nums[right];
                k--;
                right--;
            }
        }
        return res;
    }
}