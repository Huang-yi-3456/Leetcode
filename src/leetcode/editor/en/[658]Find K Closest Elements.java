//Given a sorted array arr, two integers k and x, find the k closest elements to
// x in the array. The result should also be sorted in ascending order. If there i
//s a tie, the smaller elements are always preferred. 
//
// 
// Example 1: 
// Input: arr = [1,2,3,4,5], k = 4, x = 3
//Output: [1,2,3,4]
// Example 2: 
// Input: arr = [1,2,3,4,5], k = 4, x = -1
//Output: [1,2,3,4]
// 
// 
// Constraints: 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10^4 
// Absolute value of elements in the array and x will not exceed 104 
// 
// Related Topics Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int start = 0;
        int end = nums.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == x) {
                start = mid;
                end = mid + 1;
                break;
            }
            if (nums[mid] < x) {
                start = mid ;
            } else {
                end = mid ;
            }
        }
        System.out.print(start +":"+ end);
        while (ans.size() < k) {
            if (start < 0) {
            ans.add(nums[end++]);
        } else if (end >= nums.length) {
            ans.add(0,nums[start--]);
        } else if (start < nums.length && Math.abs(nums[start] - x) <= Math.abs(nums[end] -x)) {
            ans.add(0, nums[start--]);
        } else {
            ans.add(nums[end++]);
        }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
