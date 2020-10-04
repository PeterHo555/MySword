import java.util.HashMap;
import java.util.Map;

public class Sword56_2 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
