//160.面试0207链表相交
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


//1. 遍历A，把每一个结点指针存进哈希set。  检索B，发现指针相等就返回。
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>(); 
        ListNode tmp = headA;
        while(tmp!=null){
            visited.add(tmp);  //存放的是指针
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp!=null){
            if(visited.contains(tmp)){  //指针一样后面全一样！
                return tmp;  
            }
            tmp = tmp.next;
        }
        return null;
    }
}

