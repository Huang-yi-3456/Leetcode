//Say you have an array for which the ith element is the price of a given stock 
//on day i. 
//
// Design an algorithm to find the maximum profit. You may complete at most two 
//transactions. 
//
// Note: You may not engage in multiple transactions at the same time (i.e., you
// must sell the stock before you buy again). 
//
// Example 1: 
//
// 
//Input: [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 
//3-0 = 3.
//             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), prof
//it = 4-1 = 3. 
//
// Example 2: 
//
// 
//Input: [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 
//5-1 = 4.
//             Note that you cannot buy on day 1, buy on day 2 and sell them lat
//er, as you are
//             engaging multiple transactions at the same time. You must sell be
//fore buying again.
// 
//
// Example 3: 
//
// 
//Input: [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0. 
// Related Topics Array Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[2][3][prices.length+1];
        dp[1][0][0] = Integer.MIN_VALUE;
        dp[1][1][0] = Integer.MIN_VALUE;
        dp[1][2][0] = Integer.MIN_VALUE;
        for (int day = 1; day <= prices.length; day++) {
            for (int t = 1; t <= 2; t++) {
                dp[0][t][day] = Math.max(dp[0][t][day-1], dp[1][t][day-1] + prices[day-1]);
                dp[1][t][day] = Math.max(dp[1][t][day-1], dp[0][t-1][day-1] - prices[day-1]);

            }
        }
        return dp[0][2][prices.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
