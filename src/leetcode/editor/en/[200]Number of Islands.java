//Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
//ds. An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all su
//rrounded by water. 
//
// Example 1: 
//
// 
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
// 
//
// Example 2: 
//
// 
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
// Related Topics Depth-first Search Breadth-first Search Union Find


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    char MARK = 'X';
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int ret = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    ret++;
                    grid[i][j] = MARK;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int count = 0; count < size; ++count) {
                            int[] cur = queue.poll();
                            for(int[] dir : dirs) {
                                int r = cur[0] + dir[0];
                                int c = cur[1] + dir[1];
                                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1') {
                                    continue;
                                }
                                grid[r][c] = MARK;
                                queue.offer(new int[] {r, c});
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
