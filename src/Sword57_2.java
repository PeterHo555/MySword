import java.util.ArrayList;
import java.util.List;

public class Sword57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        // 脑子里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
        // 套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
        // 当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
        for (int l = 1, r = 1, sum = 0; r <= target/2 + 1; r++) {
            sum += r;
            // 左指针右移
            while (sum > target) {
                sum -= l;
                l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
