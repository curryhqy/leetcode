package editor.cn;

import java.util.Stack;

public class BaoHanMinhanShuDeZhanLcof{
    public static void main(String[] args) {

    }

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.empty() || min.peek() >= x) {
            min.push(x);
        }
    }
    
    public void pop() {
        if (stack.pop().equals(min.peek())) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}