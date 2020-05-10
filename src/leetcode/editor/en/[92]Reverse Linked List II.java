//Reverse a linked list from position m to n. Do it in one-pass. 
//
// Note: 1 ≤ m ≤ n ≤ length of list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL, m = 2, n = 4
//Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < m -1 && cur != null; ++i) {
            pre = cur;
            cur = cur.next;
        }
        ListNode firstTail = pre;
        ListNode secondTail = cur;
        ListNode next = null;
        while (n - m + 1 > 0 && cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if (firstTail != null) {
            firstTail.next = pre;
        } else {
            head = pre;
        }
        secondTail.next = cur;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
