//Given a list of unique words, find all pairs of distinct indices (i, j) in the
// given list, so that the concatenation of the two words, i.e. words[i] + words[j
//] is a palindrome. 
//
// Example 1: 
//
// 
// 
//Input: ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]] 
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 
// Example 2: 
//
// 
//Input: ["bat","tab","cat"]
//Output: [[0,1],[1,0]] 
//Explanation: The palindromes are ["battab","tabbat"]
// 
// 
// 
// Related Topics Hash Table String Trie


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean isParldrm(String str, int start, int end) {
        while(start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    List<String> validSuffix(String str) {
        List<String> validSuffixList = new LinkedList<>();
        for (int i = str.length() - 1; i >= 0; --i) {
            if (isParldrm(str, 0, i)) {
                validSuffixList.add(str.substring(i+1));
            }
        }
        return validSuffixList;
    }

    List<String> validPrefix(String str) {
        List<String> validPrefixList = new LinkedList<>();
        for (int i = 0; i < str.length(); ++i) {
            if (isParldrm(str, i, str.length()-1)) {
                validPrefixList.add(str.substring(0, i));
            }
        }
        return validPrefixList;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }
        List<List<Integer>> ret = new LinkedList<>();
        for (String word : map.keySet()) {
            int curIndex = map.get(word);
            // case 1:
            String reversedCur = new StringBuilder(word).reverse().toString();
            if (map.containsKey(reversedCur) && map.get(reversedCur) != curIndex) {
                ret.add(Arrays.asList(curIndex, map.get(reversedCur)));
            }
            // case 2:
            List<String> validSuffixList = validSuffix(word);
            for (String suffix : validSuffixList) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (map.containsKey(reversedSuffix) && map.get(reversedSuffix) != curIndex) {
                    ret.add(Arrays.asList(map.get(reversedSuffix), curIndex));
                }

            }

            // case 3:
            List<String> validPrefixList = validPrefix(word);
            for (String prefix : validPrefixList) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (map.containsKey(reversedPrefix) && map.get(reversedPrefix) != curIndex) {
                    ret.add(Arrays.asList(curIndex, map.get(reversedPrefix)));
                }
            }
        }


        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
