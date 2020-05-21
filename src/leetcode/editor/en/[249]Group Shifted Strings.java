//Given a string, we can "shift" each of its letter to its successive letter, fo
//r example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: 
//
// 
//"abc" -> "bcd" -> ... -> "xyz" 
//
// Given a list of strings which contains only lowercase alphabets, group all st
//rings that belong to the same shifting sequence. 
//
// Example: 
//
// 
//Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
//Output: 
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
// 
// Related Topics Hash Table String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = buildKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new LinkedList<>(map.values());
    }

    String buildKey(String str) {
        if (str.length() == 0) return "-2";
        if (str.length() == 1) return "-1";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); ++i) {
            int diff = (str.charAt(i) - str.charAt(i-1) + 26) % 26;
            sb.append(diff);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
