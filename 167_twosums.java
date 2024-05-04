//167.两数之和II

//1.  暴力法  固定一个不动，寻找另一个  时间复杂度降低为O(n^2)   
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1 ; j<numbers.length; j++){
                if (numbers[i]+numbers[j]==target){
                    res[0] = i + 1;
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        return res;
    }
}
//2. 左右双指针   时间复杂度降低为O(n)   

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]==target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if(numbers[left]+numbers[right]<target){   //递增有序数列
                left++;
            } else{
                right--;
            }
            
        }
        return  new int[]{-1,-1}; // 未找到
    }
}