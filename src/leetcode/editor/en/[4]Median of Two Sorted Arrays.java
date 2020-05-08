//There are two sorted arrays nums1 and nums2 of size m and n respectively. 
//
// Find the median of the two sorted arrays. The overall run time complexity sho
//uld be O(log (m+n)). 
//
// You may assume nums1 and nums2 cannot be both empty. 
//
// Example 1: 
//
// 
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
// 
//
// Example 2: 
//
// 
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
// 
// Related Topics Array Binary Search Divide and Conquer


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int k = (total + 1) / 2;
        int start = 0;
        int end = nums1.length;
        while (start < end) {
            int m1 = start + (end - start) / 2;
            int m2 = k - m1;
            System.out.println(start);
            System.out.println(m1);
            System.out.println(m2);
            if (nums1[m1] < nums2[m2-1]) {
                start = m1 + 1;
            } else {
                end = m1;
            }
        }
        int split = start;
        int leftM = Math.max(
                split >= nums1.length ? Integer.MIN_VALUE : nums1[split-1],
                k-split-1 < 0 ? Integer.MIN_VALUE :nums2[k-split-1]);

        if (k % 2 == 1) {
            return leftM;
        }
        int rightM = Math.min(
                split+1 >= nums1.length ? Integer.MAX_VALUE : nums1[split],
                k-split < 0 ? Integer.MAX_VALUE :nums2[k-split]);

        return (leftM + rightM) / 2.0;
    }

    //int findKt
}
//leetcode submit region end(Prohibit modification and deletion)
