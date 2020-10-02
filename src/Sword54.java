import java.util.ArrayList;
import java.util.List;

public class Sword54 {
//    // 先中序遍历，存入list，再取倒数第k项
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> treeList = new ArrayList<>();
//        helper(root, treeList);
//        return treeList.get(treeList.size() - k);
//    }
//
//    private void helper(TreeNode root, List<Integer> treeList){
//        if (root == null) return;
//        if (root.left != null) helper(root.left, treeList);
//        treeList.add(root.val);
//        if (root.right != null) helper(root.right, treeList);
//    }


    // 在上述做的一点小变化
//    public int kthLargest(TreeNode root, int k) {
//        List<Integer> treeList = new ArrayList<>();
//        helper(root, treeList);
//        return treeList.get(k - 1);
//    }
//
//    private void helper(TreeNode root, List<Integer> treeList){
//        if (root == null) return;
//        if (root.right != null) helper(root.right, treeList);
//        treeList.add(root.val);
//        if (root.left != null) helper(root.left, treeList);
//    }
    private int ans = 0, cnt = 0;
    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    private void helper(TreeNode root,  int k){
        if (root == null) return;
        if (root.right != null) helper(root.right, k);
        if (++cnt == k){
            ans = root.val;
        }
        if (root.left != null) helper(root.left, k);
    }

}
