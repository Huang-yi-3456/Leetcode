//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [4,9] 
// 
//
// Note: 
//
// 
// Each element in the result should appear as many times as it shows in both ar
//rays. 
// The result can be in any order. 
// 
//
// Follow up: 
//
// 
// What if the given array is already sorted? How would you optimize your algori
//thm? 
// What if nums1's size is small compared to nums2's size? Which algorithm is be
//tter? 
// What if elements of nums2 are stored on disk, and the memory is limited such 
//that you cannot load all elements into the memory at once? 
// 
// Related Topics Hash Table Two Pointers Binary Search Sort


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        for (int num : nums1) {
            m1.put(num, m1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            m2.put(num, m2.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : m2.entrySet()) {
            int key = entry.getKey();
            if (m1.containsKey(key)) {
                int upper = Math.min(m1.get(key), entry.getValue());
                for (int i = 0;  i < upper; ++i)
                    list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
