//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// Example 1: 
//
// 
//Input: ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// Note: 
//
// All given inputs are in lowercase letters a-z. 
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    if (strs.length == 0) return "";
    int ret = 0;
    int index = 0;
    char tmp = '1';
        while (true) {
        for(String str : strs) {
            if (str.length() == index) return str.substring(0,ret);
            if (tmp == '1') {
                tmp = str.charAt(index);
            } else {
                if (tmp != str.charAt(index)) return str.substring(0,ret);
            }
        }
        ret++;
        index++;
        tmp = '1';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
