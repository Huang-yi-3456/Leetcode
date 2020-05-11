//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length < 2) return nums;
        int pivot =  nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }


    public int[] merge(int[] left, int [] right) {
        int[] ret = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ret[k++] = left[i++];
            } else {
                ret[k++] = right[j++];
            }
        }
        while (i < left.length) {
            ret[k++] = left[i++];
        }
        while (j < right.length) {
            ret[k++] = right[j++];
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
