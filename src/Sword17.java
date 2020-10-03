public class Sword17 {
    public int[] printNumbers(int n) {
        int limit = (int) Math.pow(10, n) - 1;
        int[] ans = new int[limit];
        for (int i = 0; i < limit; i++) {
            ans[i] = i + 1;
        }
        return ans;

    }
}
