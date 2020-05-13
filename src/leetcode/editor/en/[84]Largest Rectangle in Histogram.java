//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram. 
//
// 
//
// 
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//]. 
//
// 
//
// 
//The largest rectangle is shown in the shaded area, which has area = 10 unit. 
//
// 
//
// Example: 
//
// 
//Input: [2,1,5,6,2,3]
//Output: 10
// 
// Related Topics Array Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int ret = 0;
        if (heights == null || heights.length == 0) return ret;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < heights.length; ++i) {
            if (stack.peek() != -1) {
                while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                    ret = Math.max(ret, heights[stack.pop()] * (i - stack.peek() - 1));
                }
            }
            stack.push(i);
        }
        int len = heights.length;
        while(stack.peek() != -1) {
            ret = Math.max(ret, heights[stack.pop()] * (len - stack.peek() - 1));
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
