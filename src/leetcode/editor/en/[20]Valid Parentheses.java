//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
// Related Topics String Stack


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        Set<Character> open = new HashSet<>();
        Map<Character, Character> close = new HashMap<>();
        open.add('{');
        open.add('[');
        open.add('(');
        close.put('}', '{');
        close.put(']', '[');
        close.put(')', '(');
        for (int i = 0; i < s.length(); ++i) {
            if (open.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                Character last = stack.pop();
                if (!close.get(s.charAt(i)).equals(last)) {
                    return false;
                }
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
