import java.util.*;

public class Sword32_3 {
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
        // 与上一题的主要区别
        for (int i = 1; i < ansList.size(); i += 2) {
            Collections.reverse(ansList.get(i));
        }
        return ansList;
    }
}
