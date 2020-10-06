import java.util.Stack;

public class Sword09 {
    Stack<Integer> mainQueue;
    Stack<Integer> temp;

    public Sword09() {
        mainQueue = new Stack<>();
        temp = new Stack<>();
    }
    public void appendTail(int value) {
        while (!mainQueue.isEmpty()){
            temp.push(mainQueue.pop());
        }
        mainQueue.push(value);
        while (!temp.isEmpty()){
            mainQueue.push(temp.pop());
        }
    }

    public int deleteHead() {
        if(mainQueue.isEmpty()){
            return -1;
        }
        return mainQueue.pop();
    }

}
