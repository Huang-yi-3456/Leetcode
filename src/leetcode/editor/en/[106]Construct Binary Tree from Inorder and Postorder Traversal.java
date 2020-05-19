//Given inorder and postorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics Array Tree Depth-first Search


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int len = postorder.length;
        return buildTree(inorder, 0, len-1, postorder, 0, len-1);
    }

    public TreeNode buildTree(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (end1 < start1) {
            return null;
        }
        int val = postorder[end2];
        TreeNode root = new TreeNode(val);
        int index = 0;
        while (inorder[index+start1] != val) {
            index++;
        }
        root.left = buildTree(inorder, start1, start1 + index - 1,
                postorder, start2, start2 + index  -1);
        root.right = buildTree(inorder, start1 + index + 1, end1,
                postorder, start2 + index, end2 - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
