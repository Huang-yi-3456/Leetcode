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
        return quickSort(nums, 0, nums.length-1);
    }

    public int[] quickSort(int[] nums, int start, int end) {
        if (end - start < 1) {
            return nums;
        }
        int pivot = nums[end];
        int mark = start;
        for (int i = start; i <= end; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, mark++);
            }
        }
        swap(nums, mark, end);
        quickSort(nums, start, mark-1);
        quickSort(nums, mark+1, end);
        return nums;
    }

    public void swap(int[] nums, int first, int second) {
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
