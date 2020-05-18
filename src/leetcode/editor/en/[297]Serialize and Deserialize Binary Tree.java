//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Example: 
//
// 
//You may serialize the following tree:
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//as "[1,2,3,null,null,4,5]"
// 
//
// Clarification: The above format is the same as how LeetCode serializes a bina
//ry tree. You do not necessarily need to follow this format, so please be creativ
//e and come up with different approaches yourself. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree Design


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#");
                sb.append(",");
            } else {
                sb.append(cur.val);
                sb.append(",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        System.out.println(data);
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        int start = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (!vals[start].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(vals[start]));
                queue.add(parent.left);
            }
            start++;
            if (!vals[start].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(vals[start]));
                queue.add(parent.right);
            }
            start++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
