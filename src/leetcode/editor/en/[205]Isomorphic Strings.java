//Given two strings s and t, determine if they are isomorphic. 
//
// Two strings are isomorphic if the characters in s can be replaced to get t. 
//
// All occurrences of a character must be replaced with another character while 
//preserving the order of characters. No two characters may map to the same charac
//ter but a character may map to itself. 
//
// Example 1: 
//
// 
//Input: s = "egg", t = "add"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "foo", t = "bar"
//Output: false 
//
// Example 3: 
//
// 
//Input: s = "paper", t = "title"
//Output: true 
//
// Note: 
//You may assume both s and t have the same length. 
// Related Topics Hash Table


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mappings = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (mappings.containsKey(s.charAt(i))) {
                if (mappings.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else if (mappings.containsValue(t.charAt(i))) {

                return false;
            }
            mappings.put(s.charAt(i), t.charAt(i));
            // mappings.put(t.charAt(i), s.charAt(i));

        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
