public class Sword14_1 {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
//                System.out.println("dp[i]："+dp[i]+" i："+i+" j："+j);
                System.out.print("第一：" + dp[i] + " 第二：" + j * (i - j) + " 第三：" + dp[j] * (i - j)+"  ");
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
            System.out.println();
        }

        return dp[n];
    }
}
