package leetcode.editor.en;
//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics Array Two Pointers


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            twoSum(nums, - nums[i], i, result);

        }
        return result;
    }
    public void twoSum(int[] nums, int target, int index, List<List<Integer>> result) {
        int start = index + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target || (end < nums.length - 1 && nums[end] == nums[end+1])) {
                end -= 1;
            } else if (sum < target || (start > index +1 && nums[start] == nums[start-1])) {
                start += 1;
            } else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(nums[index]);
                tmp.add(nums[start++]);
                tmp.add(nums[end--]);
                result.add(new LinkedList<>(tmp));
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
