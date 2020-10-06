public class Sword13 {
    boolean[][] visit;
    public int movingCount(int m, int n, int k) {
        // 第一步：先明确递归参数
        // 第二步：明确递归终止条件
        visit = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    private int dfs(int row, int col, int m, int n, int k) {
        // 第一步：先明确递归参数
        int a = sums(row);
        int b = sums(col);
        // 第二步：明确递归终止条件
        // 边界判断、位数和与k比较、当前点是否访问过
        if (row < 0 || row >= m || col < 0 || col >= n || k < a + b || visit[row][col]) {
            return 0;
        }
        // 第三步：递推工作
        visit[row][col] = true;
        return 1 + dfs(row + 1, col, m, n, k) + dfs(row, col + 1, m, n, k);
    }

    // 位数之和计算
    private int sums(int num) {
        int sums = 0;
        while (num != 0) {
            sums += num % 10;
            num = num / 10;
        }
        return sums;
    }
}
