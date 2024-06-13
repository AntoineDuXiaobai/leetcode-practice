//142.环形链表II
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


//1. 遍历  把每一个结点指针存进哈希set。  发现指针相等，说明有环，且于此位置相交。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while(cur!=null){
            if(visited.contains(cur)){
                return cur;
            }else{
                visited.add(cur);
            }
            cur = cur.next;
        }
        
        return null;
    }
}
//2. 快慢指针法
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;  //每次走两步
            if (slow == fast) {// 有环  追上了！
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}