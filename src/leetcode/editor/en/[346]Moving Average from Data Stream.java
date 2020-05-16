//Given a stream of integers and a window size, calculate the moving average of 
//all integers in the sliding window. 
//
// Example: 
//
// 
//MovingAverage m = new MovingAverage(3);
//m.next(1) = 1
//m.next(10) = (1 + 10) / 2
//m.next(3) = (1 + 10 + 3) / 3
//m.next(5) = (10 + 3 + 5) / 3
// 
//
// 
// Related Topics Design Queue


//leetcode submit region begin(Prohibit modification and deletion)
class MovingAverage {
    Queue<Integer> queue;
    int sum;
    int len;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        sum = 0;
        len = size;
    }

    public double next(int val) {
        sum += val;
        queue.offer(val);

        if (queue.size() > len)
            sum -= queue.poll();
        return sum / (queue.size() + 0.0);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
