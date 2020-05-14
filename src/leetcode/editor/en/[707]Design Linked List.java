//Design your implementation of the linked list. You can choose to use the singl
//y linked list or the doubly linked list. A node in a singly linked list should h
//ave two attributes: val and next. val is the value of the current node, and next
// is a pointer/reference to the next node. If you want to use the doubly linked l
//ist, you will need one more attribute prev to indicate the previous node in the 
//linked list. Assume all nodes in the linked list are 0-indexed. 
//
// Implement these functions in your linked list class: 
//
// 
// get(index) : Get the value of the index-th node in the linked list. If the in
//dex is invalid, return -1. 
// addAtHead(val) : Add a node of value val before the first element of the link
//ed list. After the insertion, the new node will be the first node of the linked 
//list. 
// addAtTail(val) : Append a node of value val to the last element of the linked
// list. 
// addAtIndex(index, val) : Add a node of value val before the index-th node in 
//the linked list. If index equals to the length of linked list, the node will be 
//appended to the end of linked list. If index is greater than the length, the nod
//e will not be inserted. 
// deleteAtIndex(index) : Delete the index-th node in the linked list, if the in
//dex is valid. 
// 
//
// 
//
// Example: 
//
// 
//Input: 
//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","ge
//t"]
//[[],[1],[3],[1,2],[1],[1],[1]]
//Output:  
//[null,null,null,null,2,null,3]
//
//Explanation:
//MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//linkedList.get(1);            // returns 2
//linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//linkedList.get(1);            // returns 3
// 
//
// 
// Constraints: 
//
// 
// 0 <= index,val <= 1000 
// Please do not use the built-in LinkedList library. 
// At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and 
//deleteAtIndex. 
// 
// Related Topics Linked List Design


//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    ListNode head;
    ListNode tail;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0, null);
        tail = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode pointer = head;
        while (index-- > -1 && pointer != null) {
            pointer = pointer.next;
        }
        if (pointer == null) return -1;
        return pointer.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode next = head.next;
        head.next = new ListNode(val, next);
        if (tail == head) tail = head.next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new ListNode(val, null);
        tail = tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode pointer = head;
        ListNode pre = null;
        while (index-- > -1 && pointer != null) {
            pre = pointer;
            pointer = pointer.next;
        }
        if (index > -1) return;
        if (pointer == null) {
            addAtTail(val);
        } else {
            pre.next = new ListNode(val, pointer);
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode pointer = head;
        ListNode pre = null;
        while (index-- > -1 && pointer != null) {
            pre = pointer;
            pointer = pointer.next;
        }
        if (pointer == null) {
            pre.next = null;
            return;
        };
        ListNode next = pointer.next;
        pre.next = next;
        if (next == null) tail = pre;
    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
