//Given a binary tree, return the level order traversal of its nodes' values. (i
//e, from left to right, level by level). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        dfs(root, 0, ret);
        return ret;
    }

    void dfs(TreeNode root, int level, List<List<Integer>> ret) {
        if (level == ret.size()) {
            List<Integer> tmp = new LinkedList<>();
            ret.add(tmp);
        }
        List<Integer> current = ret.get(level);
        current.add(root.val);

        if (root.left != null) {
            dfs(root.left, level+1, ret);
        }
        if (root.right != null) {
            dfs(root.right, level+1, ret);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
