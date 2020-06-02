//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// The update(i, val) function modifies nums by updating the element at index i 
//to val. 
//
// Example: 
//
// 
//Given nums = [1, 3, 5]
//
//sumRange(0, 2) -> 9
//update(1, 2)
//sumRange(0, 2) -> 8
// 
//
// Note: 
//
// 
// The array is only modifiable by the update function. 
// You may assume the number of calls to update and sumRange function is distrib
//uted evenly. 
// 
// Related Topics Binary Indexed Tree Segment Tree


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    SegmentTree root;

    public NumArray(int[] nums) {
        if (nums.length > 0)
            root = build(nums, 0, nums.length-1);
    }

    public void update(int i, int val) {
        update(root, i, val);
    }

    private void update(SegmentTree root, int i, int val) {
        if (root.start == i && root.end == i) {
            root.val = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i > mid) {
            update(root.right, i, val);
        } else {
            update(root.left, i, val);
        }
        root.val = root.left.val + root.right.val;
    }

    public int sumRange(int i, int j) {

        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTree root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.val;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (i > mid) {
            return sumRange(root.right, i, j);
        }
        if (j <= mid) {
            return sumRange(root.left, i, j);
        }

        return sumRange(root.left, i, mid) + sumRange(root.right, mid+1, j);
    }

    private SegmentTree build(int[] nums, int start, int end) {
        if (start == end) {
            return new SegmentTree(nums[start], start, end);
        }
        int mid = start + (end - start) / 2;
        SegmentTree left = build(nums, start, mid);
        SegmentTree right = build(nums, mid + 1, end);
        SegmentTree root = new SegmentTree(left.val + right.val, start, end);
        root.left = left;
        root.right = right;
        return root;
    }

    static class SegmentTree {
        SegmentTree left;
        SegmentTree right;
        int val;
        int start;
        int end;

        public SegmentTree(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }
}



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)
