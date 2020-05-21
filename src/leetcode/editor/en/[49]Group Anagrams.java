//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new LinkedList<>());
                map.get(key).add(str);
            }
        }
        return new LinkedList<>(map.values());
    }

    String getKey(String str) {
        char[] arr = new char[26];
        for (int i = 0; i < str.length(); ++i) {
            arr[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            sb.append("#");
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
