//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// Find the minimum element. 
//
// You may assume no duplicate exists in the array. 
//
// Example 1: 
//
// 
//Input: [3,4,5,1,2] 
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: [4,5,6,7,0,1,2]
//Output: 0
// 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int[] nums, int start, int end) {
        if (nums[end] > nums[start]) {
            return nums[start];
        }
        if (start + 1 >= end) {
            return Math.min(nums[start], nums[end]);
        }
        int mid = start + (end - start) / 2;
        return Math.min(findMin(nums, start, mid), findMin(nums, mid+1, end));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
