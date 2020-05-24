//Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231. 
//
//
// Find the maximum result of ai XOR aj, where 0 ≤ i, j < n. 
//
// Could you do this in O(n) runtime? 
//
// Example: 
//
// 
//Input: [3, 10, 5, 25, 2, 8]
//
//Output: 28
//
//Explanation: The maximum result is 5 ^ 25 = 28.
// 
//
// 
// Related Topics Bit Manipulation Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = max > num ? max : num;
        }
        int len = Integer.toBinaryString(max).length();
        String[] numInStrs = new String[nums.length];
        int mask = 1 << len;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i] | mask;
            numInStrs[i] = Integer.toBinaryString(num).substring(1);
        }
        TreeNode root = new TreeNode();
        int maxRet = 0;
        for (String num : numInStrs) {
            int curRet = 0;
            TreeNode curNode = root;
            TreeNode node = root;
            for (char letter : num.toCharArray()) {
                if (curNode.children.get(letter) == null) {
                    curNode.children.put(letter, new TreeNode());
                }
                curNode = curNode.children.get(letter);
                char oppo = letter == '1' ? '0' : '1';
                if (node.children.get(oppo) != null) {
                    curRet = (curRet << 1) | 1;
                    node = node.children.get(oppo);
                } else {
                    curRet = (curRet << 1);
                    node = node.children.get(letter);
                }
            }
            maxRet = Math.max(maxRet, curRet);
        }
        return maxRet;
    }
}

class TreeNode {
    Map<Character, TreeNode> children;

    public TreeNode() {
        children = new HashMap<>();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
