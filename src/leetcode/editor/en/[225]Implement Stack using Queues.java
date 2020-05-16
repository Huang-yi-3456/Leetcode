//Implement the following operations of a stack using queues. 
//
// 
// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on top of the stack. 
// top() -- Get the top element. 
// empty() -- Return whether the stack is empty. 
// 
//
// Example: 
//
// 
//MyStack stack = new MyStack();
//
//stack.push(1);
//stack.push(2);  
//stack.top();   // returns 2
//stack.pop();   // returns 2
//stack.empty(); // returns false 
//
// Notes: 
//
// 
// You must use only standard operations of a queue -- which means only push to 
//back, peek/pop from front, size, and is empty operations are valid. 
// Depending on your language, queue may not be supported natively. You may simu
//late a queue by using a list or deque (double-ended queue), as long as you use o
//nly standard operations of a queue. 
// You may assume that all operations are valid (for example, no pop or top oper
//ations will be called on an empty stack). 
// 
// Related Topics Stack Design


//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {

    Queue<Integer> in;
    Queue<Integer> out;
    Integer last;
    /** Initialize your data structure here. */
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        last = x;
        in.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (in.size() > 1) {
            if (in.size() == 2) {
                last = in.peek();
            }
            out.offer(in.poll());
        }
        int ret = in.poll();
        Queue<Integer> tmp = in;
        in = out;
        out = tmp;
        return ret;
    }

    /** Get the top element. */
    public int top() {
        return last;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)
