//Given a non-negative index k where k ≤ 33, return the kth index row of the Pas
//cal's triangle. 
//
// Note that the row index starts from 0. 
//
// 
//In Pascal's triangle, each number is the sum of the two numbers directly above
// it. 
//
// Example: 
//
// 
//Input: 3
//Output: [1,3,3,1]
// 
//
// Follow up: 
//
// Could you optimize your algorithm to use only O(k) extra space? 
// Related Topics Array


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex+1];
        for (int i = 0; i < rowIndex +1; ++i) {
            int size = i + 1;
            int tmp = 1;
            for (int index = 0; index < size; ++index) {
                if (index == 0 || index == i) {
                    ans[index] = 1;
                } else {
                    int pre  = ans[index];
                    ans[index] = tmp + ans[index];
                    tmp = pre;
                }
            }
        }
        return Arrays.asList(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
