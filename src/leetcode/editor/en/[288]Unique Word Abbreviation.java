//An abbreviation of a word follows the form <first letter><number><last letter>
//. Below are some examples of word abbreviations: 
//
// 
//a) it                      --> it    (no abbreviation)
//
//     1
//     ↓
//b) d|o|g                   --> d1g
//
//              1    1  1
//     1---5----0----5--8
//     ↓   ↓    ↓    ↓  ↓    
//c) i|nternationalizatio|n  --> i18n
//
//              1
//     1---5----0
//     ↓   ↓    ↓
//d) l|ocalizatio|n          --> l10n
// 
//
// Assume you have a dictionary and given a word, find whether its abbreviation 
//is unique in the dictionary. A word's abbreviation is unique if no other word fr
//om the dictionary has the same abbreviation. 
//
// Example: 
//
// 
//Given dictionary = [ "deer", "door", "cake", "card" ]
//
//isUnique("dear") -> false
//isUnique("cart") -> true
//isUnique("cane") -> false
//isUnique("make") -> true
// 
// Related Topics Hash Table Design


//leetcode submit region begin(Prohibit modification and deletion)
class ValidWordAbbr {
    Map<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String str : dictionary) {
            String abbrev = toAbbr(str);
            if (!map.containsKey(abbrev)) {
                map.put(abbrev, new HashSet<>());
            }
            map.get(abbrev).add(str);
        }
    }
    
    public boolean isUnique(String word) {
        String abbrev = toAbbr(word);
        if (!map.containsKey(abbrev)) {
            return true;
        } else {
            return map.get(abbrev).size() == 1 && map.get(abbrev).contains(word);
        }
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
