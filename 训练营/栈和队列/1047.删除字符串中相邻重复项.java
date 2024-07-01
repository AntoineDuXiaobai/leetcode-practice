//1047.删除字符串中相邻重复项

//1. deque    只用push，pop时，当栈用 
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(!deque.isEmpty() && deque.peek()==ch){
                deque.pop();
            }else{
                deque.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!deque.isEmpty()){
            //开挂   pollLast, 从栈底直接输出
            res.append(deque.pollLast());
        }
        return res.toString();
    }
}   