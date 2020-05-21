//
//Given a string, find the first non-repeating character in it and return it's i
//ndex. If it doesn't exist, return -1.
// 
// Examples:
// 
//s = "leetcode"
//return 0.
//
//s = "loveleetcode",
//return 2.
// 
// 
//
// 
//Note: You may assume the string contain only lowercase letters.
// Related Topics Hash Table String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (count[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
