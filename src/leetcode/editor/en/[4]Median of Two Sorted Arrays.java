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
        if (total % 2 == 0) {
            int left = findKth(nums1, 0, nums2, 0, (total+1)/2);
            int right = findKth(nums1, 0, nums2, 0, (total+2)/2);
            return (left+right) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, (total+1)/2);
        }
    }

    int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = start1 + k/2 -1 >= nums1.length ? Integer.MAX_VALUE : nums1[start1 + k/2 -1];
        int mid2 = start2 + k/2 -1 >= nums2.length ? Integer.MAX_VALUE : nums2[start2 + k/2 -1];
        if (mid1 < mid2) {
            return findKth(nums1, start1 + k/2, nums2, start2, k - k/2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k/2, k - k/2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
