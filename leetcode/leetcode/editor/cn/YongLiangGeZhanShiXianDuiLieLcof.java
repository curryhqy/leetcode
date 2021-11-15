package editor.cn;

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof{
    public static void main(String[] args) {

    }

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    Stack<Integer> stackInsert;
    Stack<Integer> stackDelete;

    public CQueue() {
        stackInsert = new Stack<>();
        stackDelete = new Stack<>();
    }

    public void appendTail(int value) {
        stackInsert.push(value);
    }

    public int deleteHead() {
        if (stackDelete.isEmpty()) {
            while (!stackInsert.isEmpty()) {
                stackDelete.push(stackInsert.pop());
            }
        }
        if (stackDelete.isEmpty()) {
            return -1;
        } else {
            int value = stackDelete.pop();
            return value;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}