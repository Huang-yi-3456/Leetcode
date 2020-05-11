//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        backtracking(n, 1, k, ret, new LinkedList<>());
        return ret;
    }

    void backtracking(int n, int start, int k, List<List<Integer>> ret, List<Integer> tmp) {
        if (k == 0) {
            ret.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = start; i <= n; ++i) {
            tmp.add(i);
            backtracking(n, i+1, k-1, ret, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
