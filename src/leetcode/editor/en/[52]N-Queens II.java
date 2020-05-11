//The n-queens puzzle is the problem of placing n queens on an n×n chessboard su
//ch that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens p
//uzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown 
//below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int total = 0;
    public int totalNQueens(int n) {
        int[] places = new int[n];
        Arrays.fill(places, -1);
        totalNQueens(n, places);
        return total;
    }

    void totalNQueens(int n, int[] places) {
        if (n == 0) {
            total++;
            return;
        }
        int row = places.length - n;
        for (int col = 0; col < places.length; ++col) {
            if (isValidMove(places, row, col)) {
                places[row] = col;
                totalNQueens(n-1, places);
                places[row] = -1;
            }
        }
        return;
    }

    boolean isValidMove(int[] places, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (places[i] != -1) {
                if (isCollide(i, places[i], row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCollide(int row1, int col1, int row2, int col2) {
        if (row1 == row2 || col1 == col2) return true;
        if (Math.abs(row1 - row2) == Math.abs(col1-col2)) return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
