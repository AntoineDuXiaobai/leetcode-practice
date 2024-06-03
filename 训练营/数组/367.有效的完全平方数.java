//367.有效的完全平方数

//1. 二分查找
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;

        while(left<=right){
            int mid = left + (right-left)/2;
            if((long)mid*mid==num){
                return true;   //找到了就是存在
            }else if((long)mid*mid>num){
                right = mid - 1;
            }else{
                left = left + 1;
            }
        }
        //m没找到说明不存在整数
        return false;
    }
}

//2.利用Math.sqrt方法    
class Solution {
    public boolean isPerfectSquare(int num) {
        int x = (int)Math.sqrt(num);
        return x * x == num;
    }
}