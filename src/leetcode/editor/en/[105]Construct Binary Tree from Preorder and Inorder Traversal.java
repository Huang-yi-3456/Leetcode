//Given preorder and inorder traversal of a tree, construct the binary tree. 
//
// Note: 
//You may assume that duplicates do not exist in the tree. 
//
// For example, given 
//
// 
//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7] 
//
// Return the following binary tree: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if ( end1 < start1 ) {
            return null;
        }
        int val = preorder[start1];
        TreeNode root = new TreeNode(val);
        int count = 0;
        while (inorder[count + start2] != val) {
            count++;
        }

        root.left = buildTree(preorder, start1+1, start1 + count,
                inorder, start2, start2 + count -1);
        root.right = buildTree(preorder, start1+1+count, end1,
                inorder, start2+count+1, end2);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
