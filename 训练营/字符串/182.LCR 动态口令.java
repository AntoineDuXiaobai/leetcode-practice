//182. LCR动态口令


//1. StringBuilder    append元素。   先加后边的，再加前面的  最后toString
class Solution {
    public String dynamicPassword(String password, int target) {
        StringBuilder res = new StringBuilder();
        for(int i=target; i<password.length(); i++){
            char ch = password.charAt(i);
            res.append(ch);
        }
        for(int i=0; i<target; i++){
            char ch = password.charAt(i);
            res.append(ch);
        }
        return res.toString();
    }
}

//2.字符串切片    substring解法
class Solution {
    public String dynamicPassword(String password, int target) {
        String firstPart = password.substring(0,target);
        String secondPart = password.substring(target);
        return secondPart + firstPart;
    }
}