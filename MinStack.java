package homework19;

import java.util.Stack;

/**
 * Author: lisiyu
 * Created: 2019/11/13
 */

// 实现一个最小栈
// 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    // （常数时间：O(1)）
    // 用额外的空间把最小元素提前保存好

public class MinStack {
    // A 用来表示正常的栈中的数据
    // B 用来储存每一层 A 栈帧中对应的最小值
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    // 1. 将元素 x 推入栈中
    public void push(int x) {
        // 1. 先把元素插入到 A 中
        A.push(x);
        // 2. 把当前最小值插入到 B 中
        if (B.isEmpty()) {
            B.push(x);
            return;
        }
        // 如果 B 不为空，当前 B 的栈顶元素就是之前的最小值
        // 之前的最小值和当前的新元素对比一下，看看最新的最小值是什么
        int min = B.peek();
        if (x < min) {
            min = x;
        }
        B.push(min);
    }

    // 2. 删除栈顶元素
    public void pop() {
        if (A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();
    }

    // 3. 获取栈顶元素
    public int top() {
        return A.peek();
    }

    // 4. 检索栈中最小元素
    public int getMin() {
        return B.peek();
    }

}
