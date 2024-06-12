//206.反转链表

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

//1. 只需要把next指针指向反向即可  O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while(cur!=null){
            tmp = cur.next;  //先保存cur.next
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
         

    }
}
//2.递归
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        return reverse(null,head);   //前一个节点和后一个节点递归，每次翻转next方向

    }

    private ListNode reverse(ListNode pre, ListNode cur){
        if(cur==null) return pre;   //递归终止条件   最后返回最后一个节点
        ListNode tmp = null;
        tmp = cur.next;
        cur.next = pre;   //反转next方向
        return reverse(cur,tmp);
    }
}