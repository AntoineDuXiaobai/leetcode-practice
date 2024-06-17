//242.有效字母的异位词

//1. 哈希表  HashMap  O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return  false;   //长度不相等，一定不是
        Map<Character,Integer> charMapS = new HashMap<>();
        Map<Character,Integer> charMapT = new HashMap<>();
        char[] str1 = s.toCharArray(); 
        char[] str2 = t.toCharArray();
        for(char ch : str1){
            if(charMapS.containsKey(ch)){
                charMapS.put(ch,charMapS.get(ch)+1);
            }else{
                charMapS.put(ch,1);
            }
        }
        for(char ch : str2){
            if(charMapT.containsKey(ch)){
                charMapT.put(ch,charMapT.get(ch)+1);
            }else{
                charMapT.put(ch,1);
            }
        }

        return charMapS.equals(charMapT);
      
    }
}
//优化
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);   // s.charAt()直接获取字符
            table.put(ch, table.getOrDefault(ch, 0) + 1);    //获取默认或者0
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            // if (table.get(ch) < 0) {      也可以
            //     return false;
            // }
        }
        //查看有没有次数为0的？
        for (int value : table.values()) {   //查看所有的value
            if (value != 0) {
                return false;
            }
        }
        
        return true;
    }
}


//2.数组  时间复杂度O(m+n) 空间复杂度O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        
        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}