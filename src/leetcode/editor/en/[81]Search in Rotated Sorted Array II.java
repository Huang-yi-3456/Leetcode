//Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. 
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]). 
//
// You are given a target value to search. If found in the array return true, ot
//herwise return false. 
//
// Example 1: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// 
//
// Example 2: 
//
// 
//Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false 
//
// Follow up: 
//
// 
// This is a follow up problem to Search in Rotated Sorted Array, where nums may
// contain duplicates. 
// Would this affect the run-time complexity? How and why? 
// 
// Related Topics Array Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end-1]) {
                start++;
                end--;
            } else {
                if (nums[mid] >= nums[start]) {
                    if (target >= nums[start] && target < nums[mid]) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[end-1]) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
            }

        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
