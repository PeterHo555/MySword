import java.util.LinkedList;
import java.util.Queue;

public class Sword55_1 {

    // 层次遍历法
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            // 需要先记录当前层的长度，因为queue.size()会变
            int curSize = queue.size();
            for(int i = 0; i < curSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            depth++;
        }
        return depth;
    }

    // 递归，很简单的思路
//    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        if (root.left == null && root.right ==null)
//            return 1;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
}
