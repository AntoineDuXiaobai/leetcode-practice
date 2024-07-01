//20.有效的括号

//1. deque 只用push，pop，当栈用 
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            // 如果是左括号，将其推入栈中
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }else{
                // 如果是右括号，检查栈是否为空或者栈顶元素是否匹配
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                //如果不匹配，说明岔劈了
                if((ch==')' && top!='(') ||
                   (ch==']' && top!='[') ||
                   (ch=='}' && top!='{') ){
                    return false;
                   }
            }   
        }
        // 最终检查栈是否为空，为空=>所有括号都匹配; 不为空=>左括号多了
        return stack.isEmpty();
    }
}
