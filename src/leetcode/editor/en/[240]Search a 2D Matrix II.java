//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted in ascending from left to right. 
// Integers in each column are sorted in ascending from top to bottom. 
// 
//
// Example: 
//
// Consider the following matrix: 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// Given target = 5, return true. 
//
// Given target = 20, return false. 
// Related Topics Binary Search Divide and Conquer


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMatrix(matrix, target, 0, 0, matrix[0].length-1, matrix.length-1);
    }

    boolean searchMatrix(int[][] matrix, int target, int left, int up, int right, int down) {
        if (left > right || up > down) return false;
        if (target < matrix[up][left] || target > matrix[down][right]) return false;

        int mid = left + (right - left) / 2;
        int row = up;

        for (;row <= down; ++row) {
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                break;
            }
        }
        return searchMatrix(matrix, target, left, row, mid-1, down) ||
                searchMatrix(matrix, target, mid+1, up, right, row-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
