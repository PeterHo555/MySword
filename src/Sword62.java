import java.util.ArrayList;
import java.util.List;

public class Sword62 {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            // 每取一个数字，剩余的数都会减一，需要的模也减一
            n--;
        }
        return list.get(0);
    }
}
