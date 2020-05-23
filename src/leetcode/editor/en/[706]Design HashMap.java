//Design a HashMap without using any built-in hash table libraries. 
//
// To be specific, your design should include these functions: 
//
// 
// put(key, value) : Insert a (key, value) pair into the HashMap. If the value a
//lready exists in the HashMap, update the value. 
// get(key): Returns the value to which the specified key is mapped, or -1 if th
//is map contains no mapping for the key. 
// remove(key) : Remove the mapping for the value key if this map contains the m
//apping for the key. 
// 
//
// 
//Example: 
//
// 
//MyHashMap hashMap = new MyHashMap();
//hashMap.put(1, 1);          
//hashMap.put(2, 2);         
//hashMap.get(1);            // returns 1
//hashMap.get(3);            // returns -1 (not found)
//hashMap.put(2, 1);          // update the existing value
//hashMap.get(2);            // returns 1 
//hashMap.remove(2);          // remove the mapping for 2
//hashMap.get(2);            // returns -1 (not found) 
// 
//
// 
//Note: 
//
// 
// All keys and values will be in the range of [0, 1000000]. 
// The number of operations will be in the range of [1, 10000]. 
// Please do not use the built-in HashMap library. 
// 
// Related Topics Hash Table Design


//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {
    int len;
    BSTree[] buckets;
    /** Initialize your data structure here. */
    public MyHashMap() {
        len = 1000;
        buckets = new BSTree[len];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if (buckets[id(key)] == null) {
            buckets[id(key)] = new BSTree();
        }
        buckets[id(key)].insert(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (buckets[id(key)] == null) {
            return -1;
        } else {
            return buckets[id(key)].search(key);
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (buckets[id(key)] == null) {
            return;
        } else {
            buckets[id(key)].delete(key);
        }
    }

    int id(int key) {
        return key % len;
    }
}

class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class BSTree {
    TreeNode root;

    public BSTree() {

    }

    int search(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) return cur.val;
            if (cur.key < key)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return -1;
    }

    void insert(int key, int val) {
        root = insertRecursive(root, key, val);
    }

    TreeNode insertRecursive(TreeNode root, int key, int val) {
        if (root == null) {
            return new TreeNode(key, val);
        }
        if (root.key == key) {
            root.val = val;
            return root;
        }
        if (root.key < key) {
            root.right = insertRecursive(root.right, key, val);
        } else {
            root.left = insertRecursive(root.left, key, val);
        }
        return root;
    }

    void delete(int key) {

        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null && cur.key != key) {
            pre = cur;
            if (cur.key < key) {
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
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
