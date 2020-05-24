//Design a data structure that supports the following two operations: 
//
// 
//void addWord(word)
//bool search(word)
// 
//
// search(word) can search a literal word or a regular expression string contain
//ing only letters a-z or .. A . means it can represent any one letter. 
//
// Example: 
//
// 
//addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// Note: 
//You may assume that all words are consist of lowercase letters a-z. 
// Related Topics Backtracking Design Trie


//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    private TreeNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode cur = root;
        for (char letter : word.toCharArray()) {
            if (cur.children[letter-'a'] == null) {
                cur.children[letter-'a'] = new TreeNode();
            }
            cur = cur.children[letter-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TreeNode cur = root;
        return search(cur, word);
    }

    private boolean search(TreeNode root, String word) {
        if (root == null) return false;
        if (word.length() == 0) {
            if (root.isWord) {
                return true;
            } else {
                return false;
            }
        } else {
            char letter = word.charAt(0);
            if (letter != '.') {
                if (root.children[letter-'a'] == null) {
                    return false;
                } else {
                    return search(root.children[letter-'a'], word.substring(1));
                }
            } else {
                for (int i = 0; i < 26; ++i) {
                    boolean ret = search(root.children[i], word.substring(1));
                    if (ret)
                        return true;
                }
                return false;
            }
        }

    }
}
class TreeNode {
    TreeNode[] children;
    boolean isWord;
    final int len = 26;

    public TreeNode() {
        children = new TreeNode[len];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
