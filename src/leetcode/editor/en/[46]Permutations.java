//Given a collection of distinct integers, return all possible permutations. 
//
// Example: 
//
// 
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// 
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        backtracking(nums, new boolean[nums.length], new LinkedList<>(), ret);
        return ret;
    }

    void backtracking(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> ret) {
        if (tmp.size() == nums.length) {
            ret.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] == false) {
                visited[i] = true;
                tmp.add(nums[i]);
                backtracking(nums, visited, tmp, ret);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
