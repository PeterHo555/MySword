import java.util.HashMap;

public class Sword57 {
    public int[] twoSum(int[] nums, int target) {
        // 用 HashMap 存储数组元素和索引的映射，
        // 在访问到 nums[i] 时，判断 HashMap 中是否存在 target - nums[i]，
        // 如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。
        HashMap<Integer, Integer> indexForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexForNum.containsKey(target - nums[i])) {
                return new int[]{target - nums[i], nums[i]};
            } else {
                indexForNum.put(nums[i], i);
            }
        }
        return null;
    }
}
