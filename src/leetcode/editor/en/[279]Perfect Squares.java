//Given a positive integer n, find the least number of perfect square numbers (f
//or example, 1, 4, 9, 16, ...) which sum to n. 
//
// Example 1: 
//
// 
//Input: n = 12
//Output: 3 
//Explanation: 12 = 4 + 4 + 4. 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9. Related Topics Math Dynamic Programming Breadth-first
// Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int upper = (int) Math.sqrt(n) + 1;
        int ret = n;
        for (int i = 1; i <= upper; ++i) {
            int square = i * i;
            if (square <= n) {
                ret = Math.min(ret, 1 + numSquares(n - square));
            }
        }
        memo.put(n, ret);
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
