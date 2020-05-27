//Given a positive integer n, generate a square matrix filled with elements from
// 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        if (n == 0) return ret;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; ++i) {
                ret[rowBegin][i] = num++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; ++i) {
                ret[i][colEnd] = num++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; --i) {
                    ret[rowEnd][i] = num++;
                }
                rowEnd--;
            }

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; --i) {
                    ret[i][colBegin] = num++;
                }
                colBegin++;
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
