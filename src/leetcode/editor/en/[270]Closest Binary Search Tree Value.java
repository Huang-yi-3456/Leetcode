//Given a non-empty binary search tree and a target value, find the value in the
// BST that is closest to the target. 
//
// Note: 
//
// 
// Given target value is a floating point. 
// You are guaranteed to have only one unique value in the BST that is closest t
//o the target. 
// 
//
// Example: 
//
// 
//Input: root = [4,2,5,1,3], target = 3.714286
//
//    4
//   / \
//  2   5
// / \
//1   3
//
//Output: 4
// 
// Related Topics Binary Search Tree


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
    public int closestValue(TreeNode root, double target) {
        int candidate = root.val;
        if (target > root.val) {
            Integer right = root.right == null ? null : closestValue(root.right, target);
            if (right != null && Math.abs(right - target) < Math.abs(candidate - target)) {
                return right;
            } else {
                return candidate;
            }
        } else {
            Integer left = root.left == null ?null : closestValue(root.left, target);
            if (left != null && Math.abs(left - target) < Math.abs(candidate - target)) {
                return left;
            } else {
                return candidate;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
