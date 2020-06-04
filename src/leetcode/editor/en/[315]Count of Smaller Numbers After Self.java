//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
//ents to the right of nums[i]. 
//
// Example: 
//
// 
//Input: [5,2,6,1]
//Output: [2,1,1,0] 
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segm
//ent Tree


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    TreeNode root ;
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        if (nums.length == 1) return new LinkedList<Integer>(){{add(0);}};
        count = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            insert(nums[i], i);
        }
        List<Integer> ret = new LinkedList<>();
        for (int n : count) {
            ret.add(n);
        }
        return ret;
    }

    void insert(int num, int i) {
        root = insertRec(root, num, i, 0);
    }

    TreeNode insertRec(TreeNode root, int num, int i, int sum) {
        if (root == null) {
            count[i] = sum;
            root = new TreeNode(num);
        } else if (num == root.val) {
            root.dup++;
            count[i] = sum + root.sum;
        } else if (root.val < num) {
            root.right = insertRec(root.right, num, i, sum + root.sum + root.dup);
        } else {
            root.sum++;
            root.left = insertRec(root.left, num, i, sum);
        }
        return root;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int sum;
    int dup = 1;

    public TreeNode(int val) {
        this.val = val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
