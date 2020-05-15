//Given a singly linked list, group all odd nodes together followed by the even 
//nodes. Please note here we are talking about the node number and not the value i
//n the nodes. 
//
// You should try to do it in place. The program should run in O(1) space comple
//xity and O(nodes) time complexity. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 1->3->5->2->4->NULL
// 
//
// Example 2: 
//
// 
//Input: 2->1->3->5->6->4->7->NULL
//Output: 2->3->6->7->1->5->4->NULL
// 
//
// Note: 
//
// 
// The relative order inside both the even and odd groups should remain as it wa
//s in the input. 
// The first node is considered odd, the second node even and so on ... 
// 
// Related Topics Linked List


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode();
        ListNode tail1 = dummy1;
        ListNode dummy2 = new ListNode();
        ListNode tail2 = dummy2;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = head.next;
            flag = !flag;
        }
        tail1.next = dummy2.next;
        tail2.next = null;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
