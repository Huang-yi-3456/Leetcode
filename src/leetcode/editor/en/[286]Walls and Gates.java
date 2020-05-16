//You are given a m x n 2D grid initialized with these three possible values. 
//
// 
// -1 - A wall or an obstacle. 
// 0 - A gate. 
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to 
//represent INF as you may assume that the distance to a gate is less than 2147483
//647. 
// 
//
// Fill each empty room with the distance to its nearest gate. If it is impossib
//le to reach a gate, it should be filled with INF. 
//
// Example: 
//
// Given the 2D grid: 
//
// 
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
// 
//
// After running your function, the 2D grid should be: 
//
// 
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
// 
// Related Topics Breadth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    int EMPTY = Integer.MAX_VALUE;
    int BLOCK = -1;

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        List<int[]> gates = new LinkedList<>();
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0;j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    gates.add(new int[] {i, j});
                }
            }
        }
        while (!gates.isEmpty()) {
            int size = gates.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = gates.remove(0);
                for (int[] dir : dirs) {
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if (r < 0 || r >= rooms.length || c < 0 || c >= rooms[0].length || rooms[r][c] != EMPTY) {
                        continue;
                    }
                    rooms[r][c] = 1 + rooms[cur[0]][cur[1]];
                    gates.add(new int[] {r, c});
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
