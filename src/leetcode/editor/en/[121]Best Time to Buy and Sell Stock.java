package leetcode.editor.en;
//Say you have an array for which the ith element is the price of a given stock
//on day i. 
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
//t. 
//
// Note that you cannot sell a stock before you buy one. 
//
// Example 1: 
//
// 
//Input: [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 
//6-1 = 5.
//             Not 7-1 = 6, as selling price needs to be larger than buying pric
//e.
// 
//
// Example 2: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
// 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[2][prices.length+1];
        for (int i = 0; i <= prices.length; ++i) {
            dp[0][i] = 0;
        }
        dp[1][0] = Integer.MIN_VALUE;
        for (int day = 1; day <= prices.length; ++day) {
            dp[0][day] = Math.max(dp[0][day-1], dp[1][day-1] + prices[day-1]);
            dp[1][day] = Math.max(- prices[day-1], dp[1][day-1]);
        }
        return dp[0][prices.length];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
