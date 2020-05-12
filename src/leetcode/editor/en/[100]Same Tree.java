//Given two binary trees, write a function to check if they are the same or not.
// 
//
// Two binary trees are considered the same if they are structurally identical a
//nd the nodes have the same value. 
//
// Example 1: 
//
// 
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
// 
//
// Example 2: 
//
// 
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
// 
//
// Example 3: 
//
// 
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
// 
// Related Topics Tree Depth-first Search


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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (!check(p, q)) return false;
        Stack<TreeNode> s1 = new Stack<>();
        if (p != null)
            s1.push(p);
        Stack<TreeNode> s2 = new Stack<>();
        if (q != null)
            s2.push(q);

        while(!s1.isEmpty()) {
            if (s2.isEmpty()) return false;
            TreeNode c1 = s1.pop();
            TreeNode c2 = s2.pop();
            if (!check(c1.right, c2.right)) return false;
            if (c1.right != null) {

                s1.push(c1.right);
                s2.push(c2.right);
            }
            if (!check(c1.left, c2.left)) return false;
            if (c1.left != null) {
                s1.push(c1.left);
                s2.push(c2.left);
            }

        }
        if (!s2.isEmpty()) return false;
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
