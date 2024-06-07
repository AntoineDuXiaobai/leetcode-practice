//209.长度最小的数组


//1. 双指针 滑动窗口 寻找子数组
class Solution {
    public int minSubArrayLen(int target, int[] nums){
        int res = Integer.MAX_VALUE;  //定义一个最大值，如果最后还是他说明不存在子数组
        int left = 0; //左指针不懂   右指针滑动
        int sum = 0;
        for(int right = 0; right<nums.length; right++){
            sum += nums[right];
            while(sum>=target){//符合条件 可以给res
                res = Math.min(res,right-left+1);  //取 当前长度 和 最小的长度 中的min
                sum -= nums[left]; //左指针右移  减小窗口大小
                left++;
            }
        }
        return res==Integer.MAX_VALUE ? 0 : res;    // 三目运算符   表达式 ? 值 ： 值

    }
}