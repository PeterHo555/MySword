import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sword32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null)
            return ansList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()){
                tempQueue.add(queue.poll());
            }
            while (!tempQueue.isEmpty()){
                if (tempQueue.peek().left != null)
                    queue.add(tempQueue.peek().left);
                if (tempQueue.peek().right != null)
                    queue.add(tempQueue.peek().right);
                list.add(tempQueue.poll().val);
            }
            ansList.add(new ArrayList<>(list));
        }
        return ansList;
    }
}
