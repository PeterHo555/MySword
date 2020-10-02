import java.util.ArrayList;
import java.util.List;

public class Sword34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int curSum, List<Integer> list, List<List<Integer>> ans){
        // 节点为空直接返回
        if (root == null)
            return;
        // 将当前节点的值加入到list中
        list.add(root.val);
        // 每往下走一步就要计算走过的路径和
        curSum += root.val;
        // 如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null){
            if (sum == curSum)
                // 此处一定要new
                ans.add(new ArrayList<>(list));
            // 需要将最后加入的节点给移除掉，
            // 因为下一步直接return了，不会再走最后一行的remove了，
            // 所以这里在return之前提前把最后一个结点的值给remove掉。
            list.remove(list.size() - 1);
            return;
        }
        // 如果没到达叶子节点，就继续从他的左右两个子节点往下找
        dfs(root.left, sum, curSum, list, ans);
        dfs(root.right, sum, curSum, list, ans);
        // 我们要理解递归的本质，当递归往下传递的时候他最后还是会往回走，
        // 我们把这个值使用完之后还要把它给移除，这就是回溯
        list.remove(list.size() - 1);
    }
}
