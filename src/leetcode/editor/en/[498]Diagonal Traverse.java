//Given a matrix of M x N elements (M rows, N columns), return all elements of t
//he matrix in diagonal order as shown in the below image. 
//
// 
//
// Example: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//Output:  [1,2,4,7,5,3,6,8,9]
//
//Explanation:
//
// 
//
// 
//
// Note: 
//
// The total number of elements of the given matrix will not exceed 10,000. 
//


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] ret = new int[rowLen * colLen];
        LinkedList<Integer> level = new LinkedList<>();
        boolean dir = false;
        int k = 0;
        for (int i = 0; i < rowLen + colLen - 1; ++i) {
            level.clear();

            int r = i < colLen ? 0 : i - colLen + 1;
            int c = i < colLen ? i : colLen - 1;

            while (r < rowLen && c >= 0) {
                if (dir)
                    level.add(matrix[r][c]);
                else
                    level.addFirst(matrix[r][c]);
                r++;
                c--;
            }
            for (int idx = 0; idx < level.size(); ++idx) {
                ret[k++] = level.get(idx);
            }
            dir = !dir;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
