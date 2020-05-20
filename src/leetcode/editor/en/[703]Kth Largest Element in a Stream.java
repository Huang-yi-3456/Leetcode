//Design a class to find the kth largest element in a stream. Note that it is th
//e kth largest element in the sorted order, not the kth distinct element. 
//
// Your KthLargest class will have a constructor which accepts an integer k and 
//an integer array nums, which contains initial elements from the stream. For each
// call to the method KthLargest.add, return the element representing the kth larg
//est element in the stream. 
//
// Example: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
// 
//
// Note: 
//You may assume that nums' length ≥ k-1 and k ≥ 1. 
// Related Topics Heap


//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    class KthLargest {
        // insert a node into the BST
        private Node insertNode(Node root, int num) {
            if (root == null) {
                return new Node(num, 1);
            }
            if (root.val < num) {
                root.right = insertNode(root.right, num);
            } else {
                root.left = insertNode(root.left, num);
            }
            root.cnt++;
            return root;
        }

        private Node root;
        private int k;

        public KthLargest(int k, int[] nums) {
            root = null;
            for (int i = 0; i < nums.length; ++i) {
                root = insertNode(root, nums[i]);
            }
            this.k = k;
        }

        public int add(int val) {
            root = insertNode(root, val);
            return searchKth(root, k);
        }


        private int searchKth(Node root, int k) {
            if (root == null) return -1 ;
            int rightNum = root.right == null ? 0 : root.right.cnt;
            if (k == rightNum + 1) return root.val;
            if (k <= rightNum) {
                return searchKth(root.right, k);
            } else {
                return searchKth(root.left, k - rightNum - 1);
            }
        }
    }

    class Node {    // the structure for the tree node
        Node left;
        Node right;
        int val;
        int cnt;    // the size of the subtree rooted at the node
        public Node (int v, int c) {
            left = null;
            right = null;
            val = v;
            cnt = c;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
