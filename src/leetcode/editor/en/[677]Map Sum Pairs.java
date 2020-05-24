//
//Implement a MapSum class with insert, and sum methods.
// 
//
// 
//For the method insert, you'll be given a pair of (string, integer). The string
// represents the key and the integer represents the value. If the key already exi
//sted, then the original key-value pair will be overridden to the new one.
// 
//
// 
//For the method sum, you'll be given a string representing the prefix, and you 
//need to return the sum of all the pairs' value whose key starts with the prefix.
//
// 
//
// Example 1: 
// 
//Input: insert("apple", 3), Output: Null
//Input: sum("ap"), Output: 3
//Input: insert("app", 2), Output: Null
//Input: sum("ap"), Output: 5
// 
// 
// Related Topics Trie


//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    TreeNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TreeNode();
    }

    public void insert(String key, int val) {
        TreeNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.children.get(c) == null) {
                cur.children.put(c, new TreeNode());
            }
            cur = cur.children.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {

        TreeNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur == null) break;
            cur = cur.children.get(c);
        }
        return sum(cur);
    }

    public int sum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        sum += root.val;
        for (TreeNode child : root.children.values()) {
            sum += sum(child);
        }
        return sum;
    }

}
class TreeNode {
    Map<Character, TreeNode> children;
    boolean isWord;
    int val;
    public TreeNode() {
        children = new HashMap<>();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
