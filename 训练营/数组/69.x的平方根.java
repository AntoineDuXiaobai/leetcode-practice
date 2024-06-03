//69.x的平方根

//1. 二分查找
class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;

        int left = 1;
        int right = x;
        int res = -1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if((long)mid*mid<=x){    // 注意用long  防止int溢出 
                res = mid; //res是候选答案
                left = mid + 1; //尝试寻找更大的平方根
            }else if((long)mid*mid > x){
                right = mid - 1;
            }
        }
        return res;
    }
}