//Given a 2D board and a word, find if the word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cell, where
// "adjacent" cells are those horizontally or vertically neighboring. The same let
//ter cell may not be used more than once. 
//
// Example: 
//
// 
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.
// 
//
// 
// Constraints: 
//
// 
// board and word consists only of lowercase and uppercase English letters. 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics Array Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        // if (board.length == 0 || board[0].length == 0) return false;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {

                    visited.add(i + "." + j);
                    boolean found = backtracking(board, i, j, word, 1, visited);
                    if (found) return true;
                    visited.remove(i + "." + j);
                }
            }
        }
        return false;
    }

    boolean backtracking(char[][] board, int r, int c, String word, int index, Set<String> visited) {
        if (index == word.length()) {
            return true;
        }
        for (int[] dir : dirs) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            String mark = nextR + "." + nextC;
            if (nextR < 0 || nextR >= board.length
                    || nextC < 0 || nextC >= board[0].length
                    || board[nextR][nextC] != word.charAt(index)
                    || visited.contains(mark)) {
                continue;
            }
            visited.add(mark);
            boolean found = backtracking(board, nextR, nextC, word, index+1, visited);
            if (found) return true;
            visited.remove(mark);
        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
