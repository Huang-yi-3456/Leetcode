//You are given an integer array nums and you have to return a new counts array.
// The counts array has the property where counts[i] is the number of smaller elem
//ents to the right of nums[i]. 
//
// Example: 
//
// 
//Input: [5,2,6,1]
//Output: [2,1,1,0] 
//Explanation:
//To the right of 5 there are 2 smaller elements (2 and 1).
//To the right of 2 there is only 1 smaller element (1).
//To the right of 6 there is 1 smaller element (1).
//To the right of 1 there is 0 smaller element.
// Related Topics Binary Search Divide and Conquer Sort Binary Indexed Tree Segm
//ent Tree


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        if (nums.length == 0) return new LinkedList<>(){{add(0);}};
        int[] index = new int[nums.length];
        for (int i = 0; i < index.length; ++i) {
            index[i] = i;
        }
        count = new int[nums.length];
        List<Integer> ret = new LinkedList<>();

        mergeSort(index, nums, 0, nums.length-1);
        for (int i = 0; i < count.length; ++i) {
            ret.add(count[i]);
        }
        return ret;
    }

    private void mergeSort(int[] index, int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(index, nums, start, mid);
        mergeSort(index, nums, mid+1, end);
        merge(index, nums, start, mid, end);

    }

    private void merge(int[] index, int[] nums, int start, int mid, int end) {
        int[] tmp = new int[end-start+1];
        int[] index_tmp = new int[end-start+1];

        int second = mid + 1;
        int p = 0;

        for (int i = start; i <= mid; i++) {
            while (second <= end && nums[second] < nums[i]) {
                tmp[p] = nums[second];
                index_tmp[p++] = index[second++];
            }
            if (i-start < p) {
                count[index[i]] += p - (i - start);
            }
            tmp[p] = nums[i];
            index_tmp[p++] = index[i];
        }

        while (second <= end) {
            tmp[p] = nums[second];
            index_tmp[p++] = index[second++];
        }

        for (int i = 0; i < tmp.length; ++i) {
            nums[start] = tmp[i];
            index[start++] = index_tmp[i];
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
