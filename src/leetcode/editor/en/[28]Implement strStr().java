//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
//le is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great questio
//n to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty str
//ing. This is consistent to C's strstr() and Java's indexOf(). 
// Related Topics Two Pointers String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        long base = 26;
        long patternHash = 0;
        long stackHash = 0;
        long mod = 0xfffffffffffffffL;
        // System.out.println(mod);
        int i = 0;
        for (; i < needle.length(); ++i) {
            patternHash = (patternHash * base + (needle.charAt(i) - 'a')) % mod;
            stackHash = (stackHash * base + (haystack.charAt(i) - 'a')) % mod;


        }

        if (patternHash == stackHash){
            System.out.println(patternHash);
            System.out.println(stackHash);
            return i - needle.length();
        }


        long deduction = (long) Math.pow(base, needle.length());
        // sliding
        for (i = 1; i <= haystack.length() - needle.length(); ++i) {
            stackHash = (stackHash * base
                    - (haystack.charAt(i - 1) - 'a') * deduction
                    + (long) (haystack.charAt(i + needle.length() -1) - 'a')) % mod;

            if (i == 4) {
                System.out.println(patternHash);
                System.out.println(stackHash);
            }
            if (stackHash == patternHash) return i;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
