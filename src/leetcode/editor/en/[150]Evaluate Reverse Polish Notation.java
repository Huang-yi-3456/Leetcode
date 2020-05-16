//Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
//ression. 
//
// Note: 
//
// 
// Division between two integers should truncate toward zero. 
// The given RPN expression is always valid. That means the expression would alw
//ays evaluate to a result and there won't be any divide by zero operation. 
// 
//
// Example 1: 
//
// 
//Input: ["2", "1", "+", "3", "*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
// 
//
// Example 2: 
//
// 
//Input: ["4", "13", "5", "/", "+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
// 
//
// Example 3: 
//
// 
//Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//Output: 22
//Explanation: 
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
// 
// Related Topics Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>(){{
            add("+");
            add("-");
            add("*");
            add("/");
        }};

        if (tokens == null || tokens.length == 0) return 0;
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (set.contains(str)) {
                int second =Integer.valueOf(stack.pop());
                int first =Integer.valueOf(stack.pop());
                if (str.equals("+")) {
                    stack.push(String.valueOf(first + second));
                } else if (str.equals("-")) {
                    stack.push(String.valueOf(first - second));
                } else if (str.equals("*")) {
                    stack.push(String.valueOf(first * second));
                } else {
                    stack.push(String.valueOf(first / second));
                }
            } else {
                stack.push(str);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
