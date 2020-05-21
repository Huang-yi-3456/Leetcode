//Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
//idated according to the following rules: 
//
// 
// Each row must contain the digits 1-9 without repetition. 
// Each column must contain the digits 1-9 without repetition. 
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
//epetition. 
// 
//
// 
//A partially filled sudoku which is valid. 
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'. 
//
// Example 1: 
//
// 
//Input:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being
// 
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is 
//invalid.
// 
//
// Note: 
//
// 
// A Sudoku board (partially filled) could be valid but is not necessarily solva
//ble. 
// Only the filled cells need to be validated according to the mentioned rules. 
//
// The given board contain only digits 1-9 and the character '.'. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] cols = new Set[9];
        Set<Integer>[] boxes = new Set[9];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows[i] != null && rows[i].contains(board[i][j] - '0')) {
                    return false;
                } else {
                    if (rows[i] == null) {
                        rows[i] = new HashSet<>();
                    }
                    rows[i].add(board[i][j] - '0');
                }
                if (cols[j] != null && cols[j].contains(board[i][j] - '0')) {
                    return false;
                } else {
                    if (cols[j] == null) {
                        cols[j] = new HashSet<>();
                    }
                    cols[j].add(board[i][j] - '0');
                }
                int index = 3 * (i / 3) + j / 3;
                if (boxes[index] != null && boxes[index].contains(board[i][j] - '0')) {
                    return false;
                } else {
                    if (boxes[index] == null) {
                        boxes[index] = new HashSet<>();
                    }
                    boxes[index].add(board[i][j] - '0');
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
