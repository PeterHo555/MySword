public class Sword63 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        //寻找最小的值，并在它之后找一个最大的值，取差值即为答案
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else
                ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;

    }
}

