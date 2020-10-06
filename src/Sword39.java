import java.util.Arrays;

public class Sword39 {
    public int majorityElement(int[] nums) {
        // 需要的数字出现次数多于一半 那么排序后必定在中间
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
