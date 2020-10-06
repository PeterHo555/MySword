import java.util.Stack;

public class Sword31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            // 只有当此时栈顶元素等于此时popped[i]，出栈，并且i++
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        // 模拟成功则栈为空
        return stack.isEmpty();
    }
}
