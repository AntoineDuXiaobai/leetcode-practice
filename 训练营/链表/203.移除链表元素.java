//203.移除链表元素

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


//1. 使用虚拟dummy节点  O(n)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //如果是null  直接返回
        if(head==null) return head;

        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1,head);   //初始化dummy.next = head
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur!=null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;  //无论是不是，cur都要向下加一
        }
        return dummy.next;  //返回保存完好的
         
    }
}




//2.不用虚拟节点 no dummy
public ListNode removeElements(ListNode head, int val) { 
    //如果头结点的值就是val     注意防止操作空指针！ 
    while(head!=null && head.val==val){
        head = head.next;
    }

    //如果是null  直接返回
    if (head == null) {
        return head;
    }
    
    ListNode curr = head;
    while(curr!=null){
        while(curr.next!=null && curr.next.val == val){
            curr.next = curr.next.next;
        }
        curr = curr.next;
    }
    return head;
}
