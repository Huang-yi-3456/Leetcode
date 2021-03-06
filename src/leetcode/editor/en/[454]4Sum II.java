//Given four lists A, B, C, D of integer values, compute how many tuples (i, j, 
//k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero. 
//
// To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ 
//N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guar
//anteed to be at most 231 - 1. 
//
// Example: 
//
// 
//Input:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//Output:
//2
//
//Explanation:
//The two tuples are:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
//
// 
// Related Topics Hash Table Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : A) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> map2 = helper(B, map1);

        int sum = 0;
        for (int c : C) {
            for (int d : D) {
                sum += map2.getOrDefault(-1 * (c + d), 0);
            }
        }

        return sum;
    }

    Map<Integer, Integer> helper(int[] nums, Map<Integer, Integer> pre) {
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums) {
            for (Map.Entry<Integer, Integer> entry : pre.entrySet()) {
                int sum = entry.getKey() + num;
                map2.put(sum, map2.getOrDefault(sum, 0) + entry.getValue());
            }
        }
        return map2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
