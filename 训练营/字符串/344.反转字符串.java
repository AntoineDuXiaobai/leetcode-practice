//344.反转字符串


//1. 双指针，一头一尾，交换
class Solution {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length-1;
        while(head<tail){ //注意比的是数字大小而不是字母大小！
            char tmp;
            tmp = s[head];
            s[head] = s[tail];
            s[tail] = tmp;
            head++;
            tail--;
        }

    }
}