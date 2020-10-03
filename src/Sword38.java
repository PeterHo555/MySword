import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sword38 {
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c)); // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }





    // 这个有重复元素
//    List<String> res = new ArrayList<>();
//    char[] c;
//
//    public String[] permutation(String s) {
//        c = s.toCharArray();
//        dfs(0);
//        return res.toArray(new String[res.size()]);
//    }
//
//    void dfs(int x) {
//        if(x == c.length) {
//            for (int i = 0; i < c.length; i++) {
//                System.out.print(c[i]+" ");
//            }
//            System.out.println();
//            res.add(String.valueOf(c)); // 添加排列方案
//            return;
//        }
//        for(int i = x; i < c.length; i++) {
//            swap(x, i); // 交换，将 c[i] 固定在第 x 位
//            dfs(x + 1); // 开启固定第 x + 1 位字符
//            swap(x, i); // 恢复交换
//        }
//    }
//
//    void swap(int a, int b) {
//        char tmp = c[a];
//        c[a] = c[b];
//        c[b] = tmp;
//    }
}
