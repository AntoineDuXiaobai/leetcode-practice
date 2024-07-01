//225.用队列实现栈

//1. 一个双向队列deque即可。   出栈前，先把前面size--的元素，全放到队列后面
class MyStack {
    private Deque<Integer> dq;
    public MyStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.addLast(x);
    }
    
    public int pop() {
        int size = dq.size();
        size--; //把前size-1的元素全都放到后边
        while(size>0){
            dq.addLast(dq.pollFirst());
            size--;
        }
        int res =  dq.peekFirst();
        dq.pollFirst();
        return res;

    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public boolean empty() {
        return dq.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */