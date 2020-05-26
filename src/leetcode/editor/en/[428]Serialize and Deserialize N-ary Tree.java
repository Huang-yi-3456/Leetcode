//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree
// is a rooted tree in which each node has no more than N children. There is no re
//striction on how your serialization/deserialization algorithm should work. You j
//ust need to ensure that an N-ary tree can be serialized to a string and this str
//ing can be deserialized to the original tree structure. 
//
// For example, you may serialize the following 3-ary tree 
//
// 
//
// as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not necessaril
//y need to follow this format. 
//
// Or you can follow LeetCode's level order traversal serialization format, wher
//e each group of children is separated by the null value. 
//
// 
//
// For example, the above tree may be serialized as [1,null,2,3,4,5,null,null,6,
//7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]. 
//
// You do not necessarily need to follow the above suggested formats, there are 
//many more different formats that work so please be creative and come up with dif
//ferent approaches yourself. 
//
// 
// Constraints: 
//
// 
// The height of the n-ary tree is less than or equal to 1000 
// The total number of nodes is between [0, 10^4] 
// Do not use class member/global/static variables to store states. Your encode 
//and decode algorithms should be stateless. 
// 
// Related Topics Tree


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(Node root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            sb.append(root.children.size());
            sb.append(",");
            for (Node child : root.children) {
                serialize(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] vals = data.split(",");
        return deserialize(new LinkedList<>(Arrays.asList(vals)));
    }

    Node deserialize(LinkedList<String> vals) {
        String str = vals.removeFirst();
        if (str.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(str);
        Node root = new Node(val, new ArrayList<>());
        int numOfChildren = Integer.valueOf(vals.removeFirst());
        for (int i = 0; i < numOfChildren; ++i) {
            root.children.add(deserialize(vals));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
