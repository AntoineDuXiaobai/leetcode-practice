//151.反转字符串中的单词


//1. StringBuilder    append元素。    trim()修剪多余空格   split正则表达式
class Solution {
    public String reverseWords(String s) {
        // 使用trim去除字符串前后的空格
        s = s.trim();
        // 将字符串按空格分割成单词数组
        String words[] = s.split("\\s+");

        StringBuilder res = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            res.append(words[i]);
            if(i!=0){
                res.append(" ");
            }
        }

        return res.toString();

    }
} 