//541.反转字符串II


//1. 双指针，一头一尾，交换   i每次加2k
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i+=2*k){
            int start = i;
            //反转操作到第k个字符就行。  不足k个就直接操作到末尾。
            int end = Math.min(s.length()-1, start+k-1);
            while(start<end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }

        }
        //char[]->string 3种方式
        return new String(ch);
    }

}