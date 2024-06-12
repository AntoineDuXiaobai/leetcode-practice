//24.两两交换链表中的节点

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


//1. 设置虚拟头结点dH  用cur每次移动到要操作的两个节点之前  O(n)
class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(-1,head);
        ListNode cur = dummyHead;
        //判断循环截止条件，并且防止操作空指针
        while(cur.next!=null && cur.next.next!=null){
            ListNode tmp = cur.next;
            ListNode tmp1 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = tmp;
            tmp.next = tmp1;   // cur=dummyHead->2->1->3->4
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}


//2.递归
class Solution {
    public ListNode swapPairs(ListNode head) {
      // 如果结点没了或者只剩一个结点了
      if(head==null||head.next==null) 
        return head;
      ListNode firstNode = head;
      ListNode secondNode = head.next;

      firstNode.next = swapPairs(secondNode.next);
      secondNode.next = firstNode;

      return secondNode;
          
    }
}