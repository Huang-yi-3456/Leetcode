//Given a binary tree, count the number of uni-value subtrees. 
//
// A Uni-value subtree means all nodes of the subtree have the same value. 
//
// Example : 
//
// 
//Input:  root = [5,1,5,5,5,null,5]
//
//              5
//             / \
//            1   5
//           / \   \
//          5   5   5
//
//Output: 4
// 
// Related Topics Tree


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
    int ret = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        isUnivalSubtrees(root);
        return ret;
    }

    boolean isUnivalSubtrees(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            ret++;
            return true;
        }
        boolean left = isUnivalSubtrees(root.left);

        boolean right = isUnivalSubtrees(root.right);

        if (root.left != null && root.left.val != root.val) {
            return false;
        }

        if (root.right != null && root.right.val != root.val) {
            return false;
        }
        if (left && right)
            ret++;
        return true;

    }
//leetcode submit region end(Prohibit modification and deletion)
