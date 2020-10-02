import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sword32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            ansList.add(node.val);
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
