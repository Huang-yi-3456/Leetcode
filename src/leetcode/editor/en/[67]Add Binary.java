//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
//
// 
// Constraints: 
//
// 
// Each string consists only of '0' or '1' characters. 
// 1 <= a.length, b.length <= 10^4 
// Each string is either "0" or doesn't contain any leading zero. 
// 
// Related Topics Math String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        if (a.length() > b.length()) {
            return addBinary(b, a);
        }

        int add = 0;
        StringBuilder sb = new StringBuilder();
        int len = a.length();
        for (int i = 1; i <= len; ++i) {
            int val = add + (a.charAt(a.length() - i) - '0') + (b.charAt(b.length() - i) - '0');
            add = val / 2;
            val %= 2;
            if (val == 1) {
                sb.insert(0, '1');
            } else {
                sb.insert(0, '0');
            }
        }
        for (int i = a.length() - 1; i >= 0; i--) {


        }

        for (int i = b.length()-a.length() - 1; i >= 0; i--) {
            int val = add + (b.charAt(i) - '0');
            add = val / 2;
            val %= 2;
            if (val == 1) {
                sb.insert(0, 1);
            } else {
                sb.insert(0, 0);
            }
        }
        if (add != 0) {
            System.out.print(add);
            sb.insert(0, add);
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
