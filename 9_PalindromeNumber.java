// 70.爬梯子

//1. 双指针 .charAt()
class Solution {
    public boolean isPalindrome(int x) {
        String s = Int.toString(x);
        int left = 0;
        int right = s.length() - 1 ;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

//2. StringBuilder 或者 StringBuffer   .reverse()   .toString()    .equals()  判断
class Solution {
    public boolean isPalindrome(int x) {
        String original = String.valueOf(x);
        StringBuilder sb = new StringBuilder(original);
        sb.reverse();
        String reversed = sb.toString();
        return original.equals(reversed);
    }
}