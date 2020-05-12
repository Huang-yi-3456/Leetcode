//Given a robot cleaner in a room modeled as a grid. 
//
// Each cell in the grid can be empty or blocked. 
//
// The robot cleaner with 4 given APIs can move forward, turn left or turn right
//. Each turn it made is 90 degrees. 
//
// When it tries to move into a blocked cell, its bumper sensor detects the obst
//acle and it stays on the current cell. 
//
// Design an algorithm to clean the entire room using only the 4 given APIs show
//n below. 
//
// 
//interface Robot {
//  // returns true if next cell is open and robot moves into the cell.
//  // returns false if next cell is obstacle and robot stays on the current cel
//l.
//  boolean move();
//
//  // Robot will stay on the same cell after calling turnLeft/turnRight.
//  // Each turn will be 90 degrees.
//  void turnLeft();
//  void turnRight();
//
//  // Clean the current cell.
//  void clean();
//}
// 
//
// Example: 
//
// 
//Input:
//room = [
//  [1,1,1,1,1,0,1,1],
//  [1,1,1,1,1,0,1,1],
//  [1,0,1,1,1,1,1,1],
//  [0,0,0,1,0,0,0,0],
//  [1,1,1,1,1,1,1,1]
//],
//row = 1,
//col = 3
//
//Explanation:
//All grids in the room are marked by either 0 or 1.
//0 means the cell is blocked, while 1 means the cell is accessible.
//The robot initially starts at the position of row=1, col=3.
//From the top left corner, its position is one row below and three columns righ
//t.
// 
//
// Notes: 
//
// 
// The input is only given to initialize the room and the robot's position inter
//nally. You must solve this problem "blindfolded". In other words, you must contr
//ol the robot using only the mentioned 4 APIs, without knowing the room layout an
//d the initial robot's position. 
// The robot's initial position will always be in an accessible cell. 
// The initial direction of the robot will be facing up. 
// All accessible cells are connected, which means the all cells marked as 1 wil
//l be accessible by the robot. 
// Assume all four edges of the grid are all surrounded by wall. 
// 
// Related Topics Depth-first Search


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtracking(robot, visited, new int[]{0, 0}, 0);
    }


    void backtracking(Robot robot, Set<String> visited, int[] pos, int curDir) {
        robot.clean();
        visited.add(pos[0] + "." + pos[1]);
        for (int i = 0; i < 4; ++i) {
            int nextDir = (curDir + i) % 4;
            int row = pos[0] + dir[nextDir][0];
            int col = pos[1] + dir[nextDir][1];
            int[] nextPos = {row, col};
            if (!visited.contains(nextPos[0] + "." + nextPos[1]) && robot.move()) {
                backtracking(robot, visited, nextPos, nextDir);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
