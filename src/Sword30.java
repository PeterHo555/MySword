import java.util.Stack;

public class Sword30 {
    // 数据栈和最小值栈
    Stack<Integer> dataStack, minStack;
    public Sword30() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 数据栈添加数据
        dataStack.add(x);
        // 若最小值栈为空 或者
        // 加入的值小于等于当前最小值，添加最小值
        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.add(x);
    }

    public void pop() {
        // 数据栈pop，若数据栈pop的值是最小值则最小值栈也要pop
        if(dataStack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
