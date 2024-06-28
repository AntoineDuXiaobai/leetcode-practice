//28.找出字符串第一个匹配下标


//1. StringBuilder    append元素。   先加后边的，再加前面的  最后toString
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        //检索到字符长度<needle长度就够了，防止越界
        for(int i=0; i<=haystack.length()-needle.length(); i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                //substring第二个参数应该是「结束的索引」，而不是「偏移量」 i+offset
                String test = haystack.substring(i,i+needle.length());
                if(test.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}
//2. 直接用indexOf()  返回第一次出现的下标
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        return haystack.indexOf(needle);
    }
}
//3. KMP算法
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;

        // 转为字符数组，前缀加哨兵（空格）
        haystack = " " + haystack;
        needle = " " + needle;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int m = haystack.length();
        int nLen = needle.length();

        // 构建 needle 的 next 数组
        int[] next = new int[nLen];
        // KMP 算法中 j 代表已匹配的长度    
        for (int i = 2, j = 0; i < nLen; i++) {
            while (j > 0 && n[i] != n[j + 1]) j = next[j];
            if (n[i] == n[j + 1]) j++;
            next[i] = j;
        }

        // 进行匹配
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && h[i] != n[j + 1]) j = next[j];
            if (h[i] == n[j + 1]) j++;
            if (j == nLen - 1) {
                return i - nLen + 1;  // 匹配成功，返回起始索引（去掉哨兵的影响）
            }
        }

        return -1;  // 未找到
    }
}