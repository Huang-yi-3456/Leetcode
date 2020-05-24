//Implement a trie with insert, search, and startsWith methods. 
//
// Example: 
//
// 
//Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // returns true
//trie.search("app");     // returns false
//trie.startsWith("app"); // returns true
//trie.insert("app");   
//trie.search("app");     // returns true
// 
//
// Note: 
//
// 
// You may assume that all inputs are consist of lowercase letters a-z. 
// All inputs are guaranteed to be non-empty strings. 
// 
// Related Topics Design Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = root;
        for(char letter : word.toCharArray()) {
            if (cur.children[letter-'a'] == null) {
                cur.children[letter-'a'] = new TreeNode();
            }
            cur = cur.children[letter-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur = root;
        for(char letter : word.toCharArray()) {
            if (cur.children[letter-'a'] == null) {
                return false;
            }
            cur = cur.children[letter-'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(char letter : prefix.toCharArray()) {
            if (cur.children[letter-'a'] == null) {
                return false;
            }
            cur = cur.children[letter-'a'];
        }
        return true;
    }
}

class TreeNode {
    TreeNode[] children;
    boolean isWord;

    public TreeNode() {
        children = new TreeNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
