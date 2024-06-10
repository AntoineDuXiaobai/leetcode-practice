//707. 设计链表

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//1. 使用虚拟dummy头节点  O(n)
class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode dummyHead;//虚拟头结点

    //初始化
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0); 
    }
    
    public int get(int index) {
        if(index<0||index>=size) return -1;
        ListNode cur = dummyHead;
        for(int i=0; i<=index; i++){    //注意举例子带入边界！
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {   //addAtIndex(0,val);
        ListNode newNode = new ListNode(val);
        newNode.next = dummyHead.next;
        dummyHead.next = newNode;
        size++;

    }
    
    public void addAtTail(int val) { //addAtIndex(size,val);
        ListNode newNode = new ListNode(val);
        ListNode cur = dummyHead;
        while(cur.next!=null) cur = cur.next;
        //newNode.next = cur.next; 默认null
        cur.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index<0) index = 0;
        ListNode cur = dummyHead;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;     
    }
    
    public void deleteAtIndex(int index) {
        if(index<0||index>=size) return;
        ListNode cur = dummyHead;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}


class ListNode{
    int val;
    ListNode next,prev;
    ListNode() {};
    ListNode(int val){
        this.val = val;
    }
}

//2. 双链表
class MyLinkedList {  

    //记录链表中元素的数量
    int size;
    //记录链表的虚拟头结点和尾结点
    ListNode head,tail;
    
    public MyLinkedList() {
        //初始化操作
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        //这一步非常关键，否则在加入头结点的操作中会出现null.next的错误！！！
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int index) {
        //判断index是否有效
        if(index<0 || index>=size){
            return -1;
        }
        ListNode cur = this.head;
        //判断是哪一边遍历时间更短
        if(index >= size / 2){
            //tail开始
            cur = tail;
            for(int i=0; i< size-index; i++){
                cur = cur.prev;
            }
        }else{
            for(int i=0; i<= index; i++){
                cur = cur.next; 
            }
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        //等价于在第0个元素前添加
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        //等价于在最后一个元素(null)前添加
        addAtIndex(size,val);
    }
    
    public void addAtIndex(int index, int val) {
        //index大于链表长度
        if(index>size){
            return;
        }
        //index小于0
        if(index<0){
            index = 0;
        }
        size++;
        //找到前驱
        ListNode cur = this.head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        //新建结点
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;
        
    }
    
    public void deleteAtIndex(int index) {
        //判断索引是否有效
        if(index<0 || index>=size){
            return;
        }
        //删除操作
        size--;
        ListNode cur = this.head;
        for(int i=0; i<index; i++){
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */