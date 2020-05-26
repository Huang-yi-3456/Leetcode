//Given a set of words (without duplicates), find all word squares you can build
// from them. 
//
// A sequence of words forms a valid word square if the kth row and column read 
//the exact same string, where 0 ≤ k < max(numRows, numColumns). 
//
// For example, the word sequence ["ball","area","lead","lady"] forms a word squ
//are because each word reads the same both horizontally and vertically. 
//
// 
//b a l l
//a r e a
//l e a d
//l a d y
// 
//
// Note: 
// 
// There are at least 1 and at most 1000 words. 
// All words will have the exact same length. 
// Word length is at least 1 and at most 5. 
// Each word contains only lowercase English alphabet a-z. 
// 
// 
//
// Example 1:
// 
//Input:
//["area","lead","wall","lady","ball"]
//
//Output:
//[
//  [ "wall",
//    "area",
//    "lead",
//    "lady"
//  ],
//  [ "ball",
//    "area",
//    "lead",
//    "lady"
//  ]
//]
//
//Explanation:
//The output consists of two word squares. The order of output does not matter (
//just the order of words in each word square matters).
// 
// 
//
// Example 2:
// 
//Input:
//["abat","baba","atan","atal"]
//
//Output:
//[
//  [ "baba",
//    "abat",
//    "baba",
//    "atan"
//  ],
//  [ "baba",
//    "abat",
//    "baba",
//    "atal"
//  ]
//]
//
//Explanation:
//The output consists of two word squares. The order of output does not matter (
//just the order of words in each word square matters).
// 
// Related Topics Backtracking Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new LinkedList<>();
        if (words == null || words.length == 0) return ret;
        TreeNode root = new TreeNode();
        // build trie
        for (int wordIndex = 0; wordIndex < words.length; ++wordIndex) {
            TreeNode cur = root;
            String word = words[wordIndex];
            for (int i = 0; i < word.length(); ++i) {
                if (cur.children.get(word.charAt(i)) == null) {
                    cur.children.put(word.charAt(i), new TreeNode());
                }

                cur = cur.children.get(word.charAt(i));
                cur.ids.add(wordIndex);
            }
            cur.index = wordIndex;
        }

        // dfs search
        for (int i = 0; i < words.length; ++i) {
            List<String> solution = new LinkedList<>();
            String word = words[i];
            solution.add(word);
            StringBuilder sb = new StringBuilder();
            // sb.append(word.charAt(0));
            dfs(root, words, solution, ret);

        }

        return ret;
    }

    void dfs(TreeNode root, String[] words,
             List<String> tmp, List<List<String>> ret) {
        if (tmp.size() == words[0].length()) {
            ret.add(new LinkedList<>(tmp));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.size(); ++i) {
            String pre = tmp.get(i);
            sb.append(pre.charAt(tmp.size()));
        }
        List<Integer> ids = search(root, sb);
        for (int idx : ids) {

            String nextStr = words[idx];
            // if (tmp.contains(nextStr)) continue;
            tmp.add(nextStr);
            dfs(root, words, tmp, ret);
            tmp.remove(tmp.size()-1);
        }
    }

    List<Integer> search(TreeNode root, StringBuilder sb) {
        String prefix = sb.toString();
        TreeNode cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            cur = cur.children.get(prefix.charAt(i));
            if (cur == null) return new LinkedList<>();
        }
        return cur.ids;
    }

}

class TreeNode {
    Integer index;
    List<Integer> ids;
    Map<Character, TreeNode> children;

    public TreeNode() {
        ids = new ArrayList<>();
        children = new HashMap<>();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
