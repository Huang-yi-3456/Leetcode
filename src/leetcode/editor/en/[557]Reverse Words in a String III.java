//Given a string, you need to reverse the order of characters in each word withi
//n a sentence while still preserving whitespace and initial word order. 
//
// Example 1: 
// 
//Input: "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
// 
// 
//
// Note:
//In the string, each word is separated by single space and there will not be an
//y extra space in the string.
// Related Topics String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (String word : words) {
            for(int i = 0; i < word.length(); ++i) {
                sb.insert(start, word.charAt(i));
            }
            sb.append(" ");
            start = sb.length();
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
