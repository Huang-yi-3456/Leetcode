//Given a positive integer num, write a function which returns True if num is a 
//perfect square else False. 
//
// Note: Do not use any built-in library function such as sqrt. 
//
// Example 1: 
//
// 
// 
//Input: 16
//Output: true
// 
//
// 
// Example 2: 
//
// 
//Input: 14
//Output: false
// 
// 
// Related Topics Math Binary Search


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) return true;
        long start = 2 ;
        long end = num / 2 + 1;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            long operand = mid * mid;
            if (operand == num) return true;
            if (operand > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
