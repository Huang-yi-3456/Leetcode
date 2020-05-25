//Given a list of unique words, find all pairs of distinct indices (i, j) in the
// given list, so that the concatenation of the two words, i.e. words[i] + words[j
//] is a palindrome. 
//
// Example 1: 
//
// 
// 
//Input: ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]] 
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["bat","tab","cat"]
//Output: [[0,1],[1,0]] 
//Explanation: The palindromes are ["battab","tabbat"]
// 
// 
// 
// Related Topics Hash Table String Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean isPalndrm(String str, int start) {
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < words.length; ++i) {
            String word = new StringBuilder(words[i]).reverse().toString();
            TreeNode cur = root;
            for (int j = 0; j < word.length(); ++j) {
                char letter = word.charAt(j);
                if (isPalndrm(word, j)) {
                    cur.palndrmSuffix.add(i);
                }
                if (cur.children.get(letter) == null) {
                    cur.children.put(letter, new TreeNode());
                }
                cur = cur.children.get(letter);
            }
            cur.index = i;
        }
        List<List<Integer>> ret = new LinkedList<>();

        for (int curIndex = 0; curIndex < words.length; ++curIndex) {
            String word = words[curIndex];
            TreeNode curNode = root;
            for(int i = 0; i < word.length(); ++i) {
                // case 3:
                if (curNode.index != null && isPalndrm(word, i)) {
                    ret.add(Arrays.asList(curIndex, curNode.index));
                }
                char letter = word.charAt(i);
                curNode = curNode.children.get(letter);
                if (curNode == null) break;
            }
            if (curNode == null) continue;
            // case 1:
            if (curNode.index != null && curNode.index != curIndex) {
                ret.add(Arrays.asList(curIndex, curNode.index));
            }
            // case 2:
            for (int palndrmSuffixIdx : curNode.palndrmSuffix) {
                ret.add(Arrays.asList(curIndex, palndrmSuffixIdx));
            }
        }
        return ret;
    }

}

class TreeNode {
    Map<Character, TreeNode> children;
    Integer index;
    List<Integer> palndrmSuffix;
    public TreeNode() {
        children = new HashMap<>();
        palndrmSuffix = new ArrayList<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
