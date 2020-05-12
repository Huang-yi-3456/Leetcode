//Write a program to solve a Sudoku puzzle by filling the empty cells. 
//
// A sudoku solution must satisfy all of the following rules: 
//
// 
// Each of the digits 1-9 must occur exactly once in each row. 
// Each of the digits 1-9 must occur exactly once in each column. 
// Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-b
//oxes of the grid. 
// 
//
// Empty cells are indicated by the character '.'. 
//
// 
//A sudoku puzzle... 
//
// 
//...and its solution numbers marked in red. 
//
// Note: 
//
// 
// The given board contain only digits 1-9 and the character '.'. 
// You may assume that the given Sudoku puzzle will have a single unique solutio
//n. 
// The given board size is always 9x9. 
// 
// Related Topics Hash Table Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solveSudoku(char[][] board) {
        boolean found = solveSudoku(board, 0);
        // System.out.print("Found: " + found);
    }

    public boolean solveSudoku(char[][] board, int count) {
        if (count == 81) {
            return true;
        }
        int row = count / 9;
        int col = count % 9;

        if (board[row][col] != '.') {
            count++;
            boolean succ = solveSudoku(board, count);
            if (succ == true) return true;
        } else {
            for (int candidate = 1; candidate < 10; ++candidate) {
                char insert = (char)('0'+candidate);
                if (isValid(board, insert, row, col)) {
                    // System.out.print("insert: " + insert);
                    board[row][col] = insert;
                    count++;
                    boolean succ = solveSudoku(board, count);
                    if (succ == true)
                        return true;
                    board[row][col] = '.';
                    count--;
                }

            }
        }
        return false;
    }

    boolean isValid(char[][] board, char insert, int row, int col) {
        return isValidRow(board, insert, row) &&
                isValidCol(board, insert, col) &&
                isValidArea(board, insert, row, col);

    }

    boolean isValidRow(char[][] board, char insert, int row) {
        for (int i = 0; i < board[0].length; ++i) {
            if (board[row][i] == insert) {
                return false;
            }
        }
        return true;
    }

    boolean isValidCol(char[][] board, char insert, int col) {
        for (int i = 0; i < board.length; ++i) {
            if (board[i][col] == insert) {
                return false;
            }
        }
        return true;
    }

    boolean isValidArea(char[][] board, char insert, int row, int col) {
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for (int i = x; i < x +3; ++i) {
            for (int j = y; j < y + 3; ++j) {
                if (board[i][j] == insert) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
