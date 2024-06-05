//844.比较退格字符串

//1. 压栈出栈  解决退格问题
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray()){    //String-> .toCharArray()
            if(ch!='#'){   //不是退格就压栈
                stack.push(ch);
            }else{        //退格非空就出栈
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stack){
            sb.append(ch);   
        }
        return sb.toString();    //StringBuilder-> .toString()
    }
}

//2. 双指针倒退
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;  //计数器加一
                    i--;
                } else if (skipS > 0) {
                    skipS--;    //集数器减一
                    i--;      //倒退一个
                } else {
                    break;     //找到了需要比较的字符
                }    
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {    //一个处理完了另一个没处理完
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
