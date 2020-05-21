//Given a binary tree, return all duplicate subtrees. For each kind of duplicate
// subtrees, you only need to return the root node of any one of them. 
//
// Two trees are duplicate if they have the same structure with same node values
//. 
//
// Example 1: 
//
// 
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// The following are two duplicate subtrees: 
//
// 
//      2
//     /
//    4
// 
//
// and 
//
// 
//    4
// 
//Therefore, you need to return above trees' root in the form of a list. Related
// Topics Tree


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
    Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        postorder(root, list);
        return list;
    }

    String postorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return "#";
        String left = postorder(root.left, list);
        String right = postorder(root.right, list);
        String ret = left + "," + right + "," + root.val;
        map.put(ret, map.getOrDefault(ret, 0) + 1);
        if (map.get(ret) == 2) {
            list.add(root);
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
