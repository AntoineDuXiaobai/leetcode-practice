//383.赎金信

//1. 哈希表 
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;

        Map<Character,Integer> sourceMap = new HashMap<>();
        // char[] mag = magazine.toCharArray();
        // char[] ran = ransomNote.toCharArray();
        for(char ch :  magazine.toCharArray()){ // 直接字符串转换成字符数组
            //char ch = charAt(i);
            sourceMap.put(ch,sourceMap.getOrDefault(ch,0)+1);
        }
        for(char ch : ransomNote.toCharArray()){
            sourceMap.put(ch,sourceMap.getOrDefault(ch,0)-1);
        }
        for(int i : sourceMap.values()){ ///values() 返回一个Collection
            if(i<0){
                return false;
            }
        }
        return true;
    }
}

//2.数组
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        //如果确定只有小写字母，可以用数组！
        int[] count = new int[26];
        for(int i=0; i<magazine.length();i++){
            char ch = magazine.charAt(i);   //用int遍历， .charAt()
            count[ch -'a']+=1;
        }
        for(int i=0; i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            count[ch -'a']-=1;
        }
        for(int i : count){
            if(i<0){
                return false;
            }
        }
        return true;
    }
}