//
//Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
// 
//
// 
//For example, given n = 3, a solution set is:
// 
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// Related Topics String Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<>();
        backtracking(n, 0, 0, new StringBuilder(20), ret);
        return ret;
    }

    void backtracking(int n, int open, int close, StringBuilder sb, List<String> ret) {
        if (open == n && close == n) {
            ret.add(sb.toString());
            //sb.deleteCharAt(2*n-1);
            return ;
        }
        if (open == n) {
            sb.append(")");
            backtracking(n, open, close+1, sb, ret);
            sb.deleteCharAt(open + close);
        } else {
            // 1
            sb.append("(");
            backtracking(n, open+1, close, sb, ret);
            sb.deleteCharAt(open + close);
            // 2
            if (open > close) {
                sb.append(")");
                backtracking(n, open, close+1, sb, ret);
                sb.deleteCharAt(open + close);
            }


        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
