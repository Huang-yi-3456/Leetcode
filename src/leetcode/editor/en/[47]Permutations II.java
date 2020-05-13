//Given a collection of numbers that might contain duplicates, return all possib
//le unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        backtracking(nums, new boolean[nums.length], new LinkedList<>(), ret);
        return ret;
    }
    void backtracking(int[] nums, boolean[] visited, List<Integer> tmp, List<List<Integer>> ret) {
        if (tmp.size() == nums.length) {
            ret.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) {
                continue;
            }
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
