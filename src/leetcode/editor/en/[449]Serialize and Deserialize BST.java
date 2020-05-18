//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary search tree. There 
//is no restriction on how your serialization/deserialization algorithm should wor
//k. You just need to ensure that a binary search tree can be serialized to a stri
//ng and this string can be deserialized to the original tree structure. 
//
// The encoded string should be as compact as possible. 
//
// Note: Do not use class member/global/static variables to store states. Your s
//erialize and deserialize algorithms should be stateless. 
// Related Topics Tree


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

    String intToStr(int val) {
        int mask = 0xff;
        char[] bytes = new char[4];
        for (int i = 0; i < 4; ++i) {
            bytes[i] = (char) (val >> (i * 8) & mask);
        }
        return new String(bytes);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(intToStr(root.val));
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int strToInt(String bytes) {
        int result = 0;
        for (int i = 3; i >= 0; i--) {
            result = (result << 8) + (int) bytes.charAt(i);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        List<Integer> nodes = new LinkedList<>();
        int start = 0;
        int size = data.length();

        while (start < size) {
            int val = strToInt(data.substring(start, start+4));
            nodes.add(val);
            start += 4;
        }
        return deserialize(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode deserialize(List<Integer> nodes, int min, int max) {
        if (nodes.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(nodes.get(0));
        if (root.val >= max || root.val <= min) {
            return null;
        }
        nodes.remove(0);
        root.left = deserialize(nodes, min, root.val);
        root.right = deserialize(nodes, root.val, max);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
