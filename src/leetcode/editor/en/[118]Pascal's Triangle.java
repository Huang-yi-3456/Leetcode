//Given a non-negative integer numRows, generate the first numRows of Pascal's t
//riangle. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 5
//Output:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        if (numRows == 0) return ret;
        while (numRows-- > 0) {
            if (ret.size() == 0) {
                List<Integer> entry = new LinkedList<>();
                entry.add(1);
                ret.add(entry);
            } else {
                List<Integer> upper = ret.get(ret.size() - 1);
                List<Integer> entry = new LinkedList<>();
                entry.add(1);
                for (int i = 0; i < upper.size() -1; ++i) {
                    entry.add(upper.get(i) + upper.get(i+1));
                }
                entry.add(1);
                ret.add(entry);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
