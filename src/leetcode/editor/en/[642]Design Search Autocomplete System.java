//Design a search autocomplete system for a search engine. Users may input a sen
//tence (at least one word and end with a special character '#'). For each charact
//er they type except '#', you need to return the top 3 historical hot sentences t
//hat have prefix the same as the part of sentence already typed. Here are the spe
//cific rules: 
//
// 
// The hot degree for a sentence is defined as the number of times a user typed 
//the exactly same sentence before. 
// The returned top 3 hot sentences should be sorted by hot degree (The first is
// the hottest one). If several sentences have the same degree of hot, you need to
// use ASCII-code order (smaller one appears first). 
// If less than 3 hot sentences exist, then just return as many as you can. 
// When the input is a special character, it means the sentence ends, and in thi
//s case, you need to return an empty list. 
// 
//
// Your job is to implement the following functions: 
//
// The constructor function: 
//
// AutocompleteSystem(String[] sentences, int[] times): This is the constructor.
// The input is historical data. Sentences is a string array consists of previousl
//y typed sentences. Times is the corresponding times a sentence has been typed. Y
//our system should record these historical data. 
//
// Now, the user wants to input a new sentence. The following function will prov
//ide the next character the user types: 
//
// List<String> input(char c): The input c is the next character typed by the us
//er. The character will only be lower-case letters ('a' to 'z'), blank space (' '
//) or a special character ('#'). Also, the previously typed sentence should be re
//corded in your system. The output will be the top 3 historical hot sentences tha
//t have prefix the same as the part of sentence already typed. 
// 
//
// Example: 
//Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetc
//ode"], [5,3,2,2]) 
//The system have already tracked down the following sentences and their corresp
//onding times: 
//"i love you" : 5 times 
//"island" : 3 times 
//"ironman" : 2 times 
//"i love leetcode" : 2 times 
//Now, the user begins another search: 
// 
//Operation: input('i') 
//Output: ["i love you", "island","i love leetcode"] 
//Explanation: 
//There are four sentences that have prefix "i". Among them, "ironman" and "i lo
//ve leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII
// code 114, "i love leetcode" should be in front of "ironman". Also we only need 
//to output top 3 hot sentences, so "ironman" will be ignored. 
// 
//Operation: input(' ') 
//Output: ["i love you","i love leetcode"] 
//Explanation: 
//There are only two sentences that have prefix "i ". 
// 
//Operation: input('a') 
//Output: [] 
//Explanation: 
//There are no sentences that have prefix "i a". 
// 
//Operation: input('#') 
//Output: [] 
//Explanation: 
//The user finished the input, the sentence "i a" should be saved as a historica
//l sentence in system. And the following input will be counted as a new search. 
// 
//
// Note: 
//
// 
// The input sentence will always start with a letter and end with '#', and only
// one blank space will exist between two words. 
// The number of complete sentences that to be searched won't exceed 100. The le
//ngth of each sentence including those in the historical data won't exceed 100. 
// Please use double-quote instead of single-quote when you write test cases eve
//n for a character input. 
// Please remember to RESET your class variables declared in class AutocompleteS
//ystem, as static/class variables are persisted across multiple test cases. Pleas
//e see here for more details. 
// 
//
// 
// Related Topics Design Trie


//leetcode submit region begin(Prohibit modification and deletion)
class AutocompleteSystem {

    TreeNode root;
    TreeNode cur;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TreeNode();
        sb = new StringBuilder();
        cur = root;

        for (int i = 0; i < times.length; ++i) {
            add(sentences[i], times[i]);
        }
    }

    void add(String sentence, int times) {
        List<TreeNode> visited = new ArrayList<>();
        TreeNode tmp = root;
        for (char c : sentence.toCharArray()) {
            if (tmp.children[c] == null) {
                tmp.children[c] = new TreeNode();
            }
            tmp = tmp.children[c];
            visited.add(tmp);
        }
        tmp.times += times;
        tmp.s = sentence;
        for (TreeNode node : visited) {
            node.update(tmp);
        }
    }

    public List<String> input(char c) {
        List<String> ret = new LinkedList<>();
        if (c == '#') {
            add(sb.toString(), 1);
            sb.setLength(0);
            cur = root;
            return ret;
        }
        sb.append(c);
        if (cur == null) {
            return ret;
        }
        cur = cur.children[c];
        if (cur == null) return ret;

        for (int i = 0; i < cur.hotTopics.size(); ++i) {
            ret.add(cur.hotTopics.get(i).s);
        }

        return ret;
    }
}

class TreeNode implements Comparable<TreeNode> {
    TreeNode[] children;
    String s;
    int times;
    List<TreeNode> hotTopics;

    public TreeNode() {
        children = new TreeNode[256];
        hotTopics = new ArrayList<>();
    }

    public int compareTo(TreeNode node) {
        if (this.times == node.times) {
            return this.s.compareTo(node.s);
        }
        return node.times - this.times;
    }

    void update(TreeNode node) {
        if (!hotTopics.contains(node)) {
            hotTopics.add(node);
        }
        Collections.sort(hotTopics);
        if (hotTopics.size() > 3) {
            hotTopics.remove(hotTopics.size() - 1);
        }

    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
//leetcode submit region end(Prohibit modification and deletion)
