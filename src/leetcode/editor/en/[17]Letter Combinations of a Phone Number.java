//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. 
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// Example: 
//
// 
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// Note: 
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want. 
// Related Topics String Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character, ArrayList<String>> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
        map.put('2', new ArrayList<String>(){{add("a");add("b");add("c");}});
        map.put('3', new ArrayList<String>(){{add("d");add("e");add("f");}});
        map.put('4', new ArrayList<String>(){{add("g");add("h");add("i");}});
        map.put('5', new ArrayList<String>(){{add("j");add("k");add("l");}});
        map.put('6', new ArrayList<String>(){{add("m");add("n");add("o");}});
        map.put('7', new ArrayList<String>(){{add("p");add("q");add("r");add("s");}});
        map.put('8', new ArrayList<String>(){{add("t");add("u");add("v");}});
        map.put('9', new ArrayList<String>(){{add("w");add("x");add("y");add("z");}});

        List<String> ret = new LinkedList<>();
        if (digits == null || digits.length() == 0) return ret;
        backtracking(digits.toCharArray(), 0, new StringBuilder(20), ret);
        return ret;

    }
    void backtracking(char[] digits, int idx, StringBuilder sb, List<String> ret) {
        if (idx == digits.length) {
            ret.add(sb.toString());
            return;
        }
        List<String> candidates = map.get(digits[idx]);
        for (String str : candidates) {
            sb.append(str);
            backtracking(digits, idx+1, sb, ret);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
