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
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[start] < nums[end]) return nums[start];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid+1 < nums.length && nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if (mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
