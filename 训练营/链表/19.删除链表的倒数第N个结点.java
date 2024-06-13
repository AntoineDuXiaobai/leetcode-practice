//19.删除链表的倒数第N个结点

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


//1. 设置虚拟头结点dH  快慢双指针   fast先走n，在fast slow一起走，走到最后slow和fast就差n个  O(n)
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head==null) return head;
      ListNode dummyHead = new ListNode(-1,head);
      ListNode fast = dummyHead;
      ListNode slow = dummyHead;

      for(int i=0; i<n; i++){
          fast = fast.next;
      }
      
      while(fast.next!=null){
          fast = fast.next;
          slow = slow.next;
      }
      slow.next = slow.next.next;
      return dummyHead.next;
     
  }
}

