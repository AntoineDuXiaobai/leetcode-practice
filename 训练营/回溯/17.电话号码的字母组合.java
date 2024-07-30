//17.电话号码的字母组合
//update

//1. 递归    回溯   
class Solution {
    //创建一个String数组  作为映射
     private String[] map = {
        "",   //0
        "",    //1
        "abc", //2
        "def", //3
        "ghi", //4
        "jkl", //5
        "mno", //6
        "pqrs", //7
        "tuv", //8
        "wxyz" //9
    };
    private List<String> res = new ArrayList<>();    //返回结果
    private StringBuilder sb = new StringBuilder();     //用sb收集字符

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return res;
        }
        backtracking(digits,0);
        return res;

    }
    private void backtracking(String digits, int index){
        //终止条件
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        //先映射
        int digit = digits.charAt(index) - '0';   //转化为数字
        String letter = map[digit];   //通过map找到对应的字母组合
        //再循环回溯
        for(int i=0; i<letter.length();i++){
            sb.append(letter.charAt(i));  //String用charAt
            backtracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}