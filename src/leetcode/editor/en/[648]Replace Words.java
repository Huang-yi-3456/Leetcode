//In English, we have a concept called root, which can be followed by some other
// words to form another longer word - let's call this word successor. For example
//, the root an, followed by other, which can form another word another. 
//
// Now, given a dictionary consisting of many roots and a sentence. You need to 
//replace all the successor in the sentence with the root forming it. If a success
//or has many roots can form it, replace it with the root with the shortest length
//. 
//
// You need to output the sentence after the replacement. 
//
// 
// Example 1: 
//
// 
//Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the b
//attery"
//Output: "the cat was rat by the bat"
// 
//
// 
// Constraints: 
//
// 
// The input will only have lower-case letters. 
// 1 <= dict.length <= 1000 
// 1 <= dict[i].length <= 100 
// 1 <= sentence words number <= 1000 
// 1 <= sentence words length <= 1000 
// 
// Related Topics Hash Table Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    TreeNode root;
    public String replaceWords(List<String> dict, String sentence) {
        root = new TreeNode();
        StringBuilder sb = new StringBuilder();
        insert(dict);

        String[] words = sentence.split("\\s+");
        for (String word : words) {
            sb.append(search(word));
            sb.append(" ");
        }

        return sb.substring(0, sb.length()-1);
    }

    void insert(List<String> dict) {
        for (String word : dict) {
            TreeNode cur = root;
            for (char letter : word.toCharArray()) {
                if (cur.children.get(letter) == null) {
                    cur.children.put(letter, new TreeNode());
                }
                cur = cur.children.get(letter);
            }
            cur.isWord = true;
        }
    }

    StringBuilder search(String word) {
        TreeNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (cur.isWord)
                break;
            if (cur.children.get(letter) == null) {
                sb.setLength(0);
                sb.append(word);
                break;
            }
            sb.append(letter);

            cur = cur.children.get(letter);
        }
        return sb;
    }
}

class TreeNode {
    Map<Character, TreeNode> children;
    boolean isWord;

    public TreeNode() {
        children = new HashMap<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
