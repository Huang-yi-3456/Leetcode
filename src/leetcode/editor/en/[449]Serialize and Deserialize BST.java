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

    String intToStr(int n) {
        int mask = 0xff;
        char[] bytes = new char[4];
        for (int i = 3; i >= 0; i--) {
            bytes[3 - i] = (char) (n >> 8 * i & mask);
        }
        return new String(bytes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.print(data);
        if(data == null) return null;
        LinkedList<Integer> nodes = new LinkedList<>();
        int size = data.length();
        for (int i = 0; i < size; ) {
            String str = data.substring(i, i+4);
            nodes.add(stringToInt(str));
            //System.out.println(data.substring(i, i+4));
            i += 4;
        }
        return deserialize(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int stringToInt(String bytesStr) {
        int result = 0;
        for(char b : bytesStr.toCharArray()) {
            result = (result << 8) + (int)b;
        }
        return result;
    }

    TreeNode deserialize(LinkedList<Integer> nodes, int min, int max) {
        if (nodes.size() == 0) {
            return null;
        }
        int val = nodes.get(0);
        if (val >= max || val <= min) return null;
        TreeNode root = new TreeNode(val);
        nodes.remove(0);
        root.left = deserialize(nodes, min, val);
        root.right = deserialize(nodes, val, max);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
