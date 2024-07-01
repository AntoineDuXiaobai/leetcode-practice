//150.逆波兰表达式求值

//1. deque 
class Solution {
    private int calculate(int a, int b, String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default: 
                return -1;
        }
    }

    public int evalRPN(String[] tokens) {
        //栈里只存int
        Deque<Integer> deque = new ArrayDeque<>();
        for(String token:tokens){
            //如果是运算符，先计算结果，再把int入栈
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                if(deque.size()>=2){
                    int b = deque.pop();
                    int a = deque.pop();
                    int res = calculate(a,b,token);
                    deque.push(res);
                }
            }else{
                //如果不是运算符，转换成int入栈
                deque.push(Integer.parseInt(token));
            }
        }
        return deque.pop();
    }
}