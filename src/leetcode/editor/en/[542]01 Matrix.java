//Given a matrix consists of 0 and 1, find the distance of the nearest 0 for eac
//h cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
//
// Example 1: 
//
// 
//Input:
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
//
//Output:
//[[0,0,0],
// [0,1,0],
// [0,0,0]]
// 
//
// Example 2: 
//
// 
//Input:
//[[0,0,0],
// [0,1,0],
// [1,1,1]]
//
//Output:
//[[0,0,0],
// [0,1,0],
// [1,2,1]]
// 
//
// 
//
// Note: 
//
// 
// The number of elements of the given matrix will not exceed 10,000. 
// There are at least one 0 in the given matrix. 
// The cells are adjacent in only four directions: up, down, left and right. 
// 
// Related Topics Depth-first Search Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLen = matrix.length * matrix[0].length + 1;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] != 0) {
                    int up = i - 1 < 0 ? maxLen : dp[i-1][j];
                    int left = j - 1 < 0 ? maxLen : dp[i][j-1];
                    dp[i][j] = Math.min(up, left) + 1;
                } else {
                    dp[i][j] = 0;
                }

            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    int right = j + 1 >= matrix[0].length ? maxLen : dp[i][j+1];
                    int down = i + 1 >= matrix.length ? maxLen : dp[i+1][j];
                    dp[i][j] = Math.min(dp[i][j], Math.min(right, down) + 1);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
