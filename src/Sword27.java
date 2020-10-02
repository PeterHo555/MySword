public class Sword27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;//后面的操作会改变 left 指针，因此先保存下来
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tempLeft);
        return root;
    }
}
