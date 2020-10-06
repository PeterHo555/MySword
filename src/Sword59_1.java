public class Sword59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int l = 0, r = k - 1; l < len - k + 1 ; l++) {
            ans[l] = getMax(nums, l, r);
            r++;
        }
        return ans;
    }

    private int getMax(int[] nums, int l, int r){
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
