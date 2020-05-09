//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// If the target is not found in the array, return [-1, -1]. 
//
// Example 1: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4] 
//
// Example 2: 
//
// 
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1] 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int start = findStart(nums, target);
        if (start == -1){
            return new int[] {-1, -1};
        }
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }

    public int findStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) /2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }

    public int findEnd(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) /2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end= mid;
            }
        }
        if (nums[end] == target) {
            return end;
        } else if(nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
