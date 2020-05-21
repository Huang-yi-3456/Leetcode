//Given an array of integers, find out whether there are two distinct indices i 
//and j in the array such that the absolute difference between nums[i] and nums[j]
// is at most t and the absolute difference between i and j is at most k. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
// 
//
// 
// Example 3: 
//
// 
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
// 
// 
// 
// Related Topics Sort Ordered Map


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || t < 0) return false;
        Map<Long, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = num < min ? num : min;
        }
        for (int i = 0; i < nums.length; ++i) {
            long curBucket = getIndex(min, nums[i], t);
            if (map.containsKey(curBucket)) {
                return true;
            }
            if (map.containsKey(curBucket-1)) {
                if (Math.abs((long)nums[i] - nums[map.get(curBucket-1)]) <= (long) t) {
                    return true;
                }

            }
            if (map.containsKey(curBucket+1)) {
                if (Math.abs((long)nums[i] - nums[map.get(curBucket+1)]) <= (long) t) {
                    return true;
                }
            }
            map.put(curBucket, i);
            if (i >= k) {
                map.remove(getIndex(min, nums[i-k], t));
            }
        }

        return false;
    }

    long getIndex(int min, int num, int interval) {
        return ((long) num - (long) min) / ((long) interval + 1);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
