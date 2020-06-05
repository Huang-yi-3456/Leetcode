//Given an array w of positive integers, where w[i] describes the weight of inde
//x i, write a function pickIndex which randomly picks an index in proportion to i
//ts weight. 
//
// Note: 
//
// 
// 1 <= w.length <= 10000 
// 1 <= w[i] <= 10^5 
// pickIndex will be called at most 10000 times. 
// 
//
// Example 1: 
//
// 
//Input: 
//["Solution","pickIndex"]
//[[[1]],[]]
//Output: [null,0]
// 
//
// 
// Example 2: 
//
// 
//Input: 
//["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
//[[[1,3]],[],[],[],[],[]]
//Output: [null,0,1,1,1,0] 
// 
//
// Explanation of Input Syntax: 
//
// The input is two lists: the subroutines called and their arguments. Solution'
//s constructor has one argument, the array w. pickIndex has no arguments. Argumen
//ts are always wrapped with a list, even if there aren't any. 
// Related Topics Binary Search Random


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] count;
    int sum;
    Random rand;
    public Solution(int[] w) {
        count = new int[w.length];
        for (int i = 0; i < w.length; ++i) {
            count[i] = sum;
            sum += w[i];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int next = rand.nextInt(sum);
        int start = 0;
        int end = count.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (count[mid] == next) return mid;
            if (next < count[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (next >= count[end]) return end;
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)
