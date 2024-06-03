//704.二分查找


//1.  暴力法  时间复杂度O(n) 空间复杂度O(1)  只用了循环变量i
class Solution {
    public int search(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(target==nums[i]){
                return i;
            }
        }

        return -1;
    }
}

//2. 二分查找
//左闭右闭
class Solution {
    public int search(int[] nums, int target) {
        //减少不必要的判断
        if(target<nums[0]||target>nums[nums.length-1]) return -1;

        int left = 0;
        int right = nums.length-1;

        //因为右闭，所以能取到right  <=
        while(left<=right){
            //mid必须定义在循环内部，每次更新
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){  //因为能取到，所以已经判断过边界了，直接-1
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}



//左闭右开  【left,right)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length; //因为取不到，所以用边界就行

        //因为右开,所以取不到right  <=
        while(left<right){
            //mid必须定义在循环内部，每次更新
            int mid = (left + right) / 2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){  //因为取不到，所以用边界就行
                right = mid;
            }else{
                left = mid + 1;  //左边界能取到，所以已经判断过了，得+1
            }
        }
        return -1;
    }
}
