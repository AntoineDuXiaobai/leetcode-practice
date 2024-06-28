//459.重复的子字符串


//1. 新建ss， 掐头去尾后，查找ss中有没有s
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String ss = s+s;
        if(ss.substring(1,ss.length()-1).contains(s)){
            return true;
        }else{
            return false;
        }
    }
}
//同理, 可以查找ss中第一次s出现的索引，如果正常，应该提前出现在第二个s之前
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
//2. KMP算法
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        int len = s.length();
        // 原串加个空格(哨兵)
        s = " " + s;
        int next[] = new int[len+1];
        char[] chars = s.toCharArray();
        //构造next前缀表
        for(int i=2, j=0; i<len+1; i++){
            // 匹配不成功，j回到前一位置 next 数组所对应的值
            while(j>0 && chars[i] != chars[j+1]) j=next[j];
            // 匹配成功，j往后移
            if(chars[i]==chars[j+1]) j++;
            // 更新 next 数组的值
            next[i] = j;
        }
        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if(next[len]>0 && len%(len-next[len])==0) return true;
        return false;

    }
}