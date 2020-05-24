//Given a 2D board and a list of words from the dictionary, find all words in th
//e board. 
//
// Each word must be constructed from letters of sequentially adjacent cell, whe
//re "adjacent" cells are those horizontally or vertically neighboring. The same l
//etter cell may not be used more than once in a word. 
//
// 
//
// Example: 
//
// 
//Input: 
//board = [
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//words = ["oath","pea","eat","rain"]
//
//Output: ["eat","oath"]
// 
//
// 
//
// Note: 
//
// 
// All inputs are consist of lowercase letters a-z. 
// The values of words are distinct. 
// 
// Related Topics Backtracking Trie


import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    TreeNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TreeNode();
        for (String word :  words) {
            insert(word);
        }
        List<String> ret = new LinkedList<>();
        if (board.length == 0 || board[0].length == 0)
            return ret;
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[0].length; ++c) {
                char letter = board[r][c];
                if (root.children[letter-'a'] != null)
                    backtracking(board, r, c, root, seen, ret);
            }
        }
        return ret;
    }

    void backtracking(char[][] board, int r, int c, TreeNode root, boolean[][] seen, List<String> ret) {
        char letter = board[r][c];
        seen[r][c] = true;
        TreeNode cur = root.children[letter-'a'];
        if (cur.str != null) {
            ret.add(cur.str);
            cur.str = null;
        }

        for (int[] dir : dirs) {
            int nextR = dir[0] + r;
            int nextC = dir[1] + c;
            if (nextR < 0 || nextR >= board.length
                    || nextC < 0 || nextC >= board[0].length
                    || seen[nextR][nextC]) {
                continue;
            }
            if (cur.children[board[nextR][nextC] - 'a'] != null)
                backtracking(board, nextR, nextC, cur, seen, ret);

        }

        seen[r][c] = false;
    }
    void insert(String str) {
        TreeNode cur = root;
        for (char letter : str.toCharArray()) {
            if (cur.children[letter-'a'] == null) {
                cur.children[letter-'a'] = new TreeNode();
            }
            cur = cur.children[letter-'a'];
        }
        // cur.isWord = true;
        cur.str = str;
    }
}

class TreeNode {
    TreeNode[] children;
    // boolean isWord;
    String str;
    public TreeNode() {
        children = new TreeNode[26];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
