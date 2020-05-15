//You are given two non-empty linked lists representing two non-negative integer
//s. The most significant digit comes first and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Follow up: 
//What if you cannot modify the input lists? In other words, reversing the lists
// is not allowed.
// 
//
// 
//Example:
// 
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode tail = null;
        int add = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + add + l2.val;
            add = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + add;
            add = sum / 10;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + add;
            add = sum / 10;
            ListNode node = new ListNode(sum % 10);
            tail.next = node;
            tail = tail.next;
            l2 = l2.next;
        }
        if (add != 0) {
            ListNode node = new ListNode(add % 10);
            tail.next = node;
            tail = tail.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
