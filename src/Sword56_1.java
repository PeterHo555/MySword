import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sword56_1 {
    public int[] singleNumbers(int[] nums) {
//        int[] ans = new int[2];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
//        }
//        int i = 0;
//        for (int num : map.keySet()) {
//            if (map.get(num) == 1) {
//                ans[i] = num;
//                i++;
//            }
//        }
//        return ans;
        int len = nums.length;
        int[] count = new int[len];
        Arrays.fill(count, 0);
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int[] ans = new int[2];
        int i = 0;
        for (int num : count) {
            if (num == 1) {
                ans[i] = num;
                i++;
            }
        }
        return ans;

    }
}
