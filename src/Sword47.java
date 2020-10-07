public class Sword47 {
    public int maxValue(int[][] grid) {
//        if (grid == null || grid.length == 0)
//            return 0;
//        int m = grid.length, n = grid[0].length;
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[i][j] = Math.max(grid[i - 1][j - 1] + dp[i - 1][j], grid[i - 1][j - 1] + dp[i][j - 1]);
//            }
//        }
//        return dp[m][n];

        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        return helper(grid, m, n);
    }

    private int helper(int[][] grid, int m, int n){
        if (m == 0 && n == 0)
            return grid[m][n];
        if (n == 0)
            return grid[m][n] + helper(grid, m - 1, 0);
        if (m == 0)
            return grid[m][n] + helper(grid, 0, n - 1);
        return grid[m][n] + Math.max(helper(grid, m - 1, n), helper(grid, m, n - 1));
    }
}
