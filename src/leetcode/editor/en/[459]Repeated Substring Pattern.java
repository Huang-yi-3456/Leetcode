//Given a non-empty string check if it can be constructed by taking a substring 
//of it and appending multiple copies of the substring together. You may assume th
//e given string consists of lowercase English letters only and its length will no
//t exceed 10000. 
//
// 
//
// Example 1: 
//
// 
//Input: "abab"
//Output: True
//Explanation: It's the substring "ab" twice.
// 
//
// Example 2: 
//
// 
//Input: "aba"
//Output: False
// 
//
// Example 3: 
//
// 
//Input: "abcabcabcabc"
//Output: True
//Explanation: It's the substring "abc" four times. (And the substring "abcabc" 
//twice.)
// 
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 0) return true;
        int len = s.length();
        int[] next = new int[len + 1];
        build(next, s);
        return next[len] > 0 && (len % (len - next[len]) == 0);
    }

    void build(int[] next, String pattern) {
        for (int i = 1, j = 0; i < pattern.length(); ++i) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                next[i+1] = ++j;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
