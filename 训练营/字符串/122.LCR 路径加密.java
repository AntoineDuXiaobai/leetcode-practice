//122. LCR路径加密


//1. StringBuilder    append元素。   最后toString
class Solution {
    public String pathEncryption(String path) {
        //return path.replace("."," ");     replace替换，一步完成
        StringBuilder res = new StringBuilder();
        for(char ch:path.toCharArray()){
            if(ch=='.'){
                ch = ' ';
            }
            res.append(ch);
        }
        return res.toString();
    }
}