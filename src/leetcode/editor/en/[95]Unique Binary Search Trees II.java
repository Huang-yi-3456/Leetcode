//Given an integer n, generate all structurally unique BST's (binary search tree
//s) that store values 1 ... n. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
// Related Topics Dynamic Programming Tree


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int root = start; root <= end; ++root) {
            System.out.println("root: " + root);
            List<TreeNode> left = generateTrees(start, root-1);
            List<TreeNode> right = generateTrees(root+1, end);
            for (TreeNode leftNode : left) {
                for(TreeNode rightNode : right) {
                    TreeNode rootNode = new TreeNode(root, leftNode, rightNode);
                    ans.add(rootNode);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
