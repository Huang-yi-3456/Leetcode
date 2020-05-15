//Given a linked list, rotate the list to the right by k places, where k is non-
//negative. 
//
// Example 1: 
//
// 
//Input: 1->2->3->4->5->NULL, k = 2
//Output: 4->5->1->2->3->NULL
//Explanation:
//rotate 1 steps to the right: 5->1->2->3->4->NULL
//rotate 2 steps to the right: 4->5->1->2->3->NULL
// 
//
// Example 2: 
//
// 
//Input: 0->1->2->NULL, k = 4
//Output: 2->0->1->NULL
//Explanation:
//rotate 1 steps to the right: 2->0->1->NULL
//rotate 2 steps to the right: 1->2->0->NULL
//rotate 3 steps to the right: 0->1->2->NULL
//rotate 4 steps to the right: 2->0->1->NULL 
// Related Topics Linked List Two Pointers


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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        int len = 0;
        ListNode tail = null;
        while(p != null) {
            tail = p;
            p = p.next;
            len++;
        }
        // if (len % k==0) return head;
        int move = len - k % len ;
        if (move == len) return head;
        ListNode next = null;
        while (move-- > 0) {
            next = head.next;
            head.next = null;
            tail.next = head;
            tail = tail.next;
            head = next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
