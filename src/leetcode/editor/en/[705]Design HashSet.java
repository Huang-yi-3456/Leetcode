//Design a HashSet without using any built-in hash table libraries. 
//
// To be specific, your design should include these functions: 
//
// 
// add(value): Insert a value into the HashSet. 
// contains(value) : Return whether the value exists in the HashSet or not. 
// remove(value): Remove a value in the HashSet. If the value does not exist in 
//the HashSet, do nothing. 
// 
//
// 
//Example: 
//
// 
//MyHashSet hashSet = new MyHashSet();
//hashSet.add(1);         
//hashSet.add(2);         
//hashSet.contains(1);    // returns true
//hashSet.contains(3);    // returns false (not found)
//hashSet.add(2);          
//hashSet.contains(2);    // returns true
//hashSet.remove(2);          
//hashSet.contains(2);    // returns false (already removed)
// 
//
// 
//Note: 
//
// 
// All values will be in the range of [0, 1000000]. 
// The number of operations will be in the range of [1, 10000]. 
// Please do not use the built-in HashSet library. 
// 
// Related Topics Hash Table Design


//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {
    BSTree[] buckets;
    int len;
    /** Initialize your data structure here. */
    public MyHashSet() {
        len = 2;
        buckets = new BSTree[2];
    }

    public void add(int key) {
        int id = key % len;
        if (buckets[id] == null) {
            BSTree tree = new BSTree();
            buckets[id] = tree;
        }
        buckets[id].insert(key);
    }

    public void remove(int key) {
        int id = key % len;
        if (buckets[id] != null)
            buckets[id].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int id = key % len;
        return buckets[id] != null && buckets[id].search(key);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

class BSTree {
    TreeNode root;

    public BSTree() {

    }

    boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) return true;
            if (cur.val < val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return false;
    }

    void insert(int val) {
        root = insertRecursive(root, val);
    }

    TreeNode insertRecursive(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) return root;
        if (root.val < val) {
            root.right = insertRecursive(root.right, val);
        } else {
            root.left = insertRecursive(root.left, val);
        }
        return root;
    }

    void delete(int val) {

        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null && cur.val != val) {
            pre = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (cur == null) return;
        if (pre == null) {
            root = delete(cur);
        } else if (pre.left == cur) {
            pre.left = delete(cur);
        } else {
            pre.right = delete(cur);
        }
    }

    TreeNode delete(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;
        TreeNode leftMost = root.right;
        while (leftMost.left != null) {
            leftMost = leftMost.left;
        }
        leftMost.left = root.left;
        return root.right;
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
