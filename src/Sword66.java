import java.util.Arrays;

public class Sword66 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int left = 1, right = 1;     //left：从左边累乘，right：从右边累乘
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for(int i = 0; i < n; ++i){
            //最终每个元素其左右乘积进行相乘得出结果
            ans[i] *= left;       //乘以其左边的乘积
            left *= a[i];
            ans[n - 1 - i] *= right;  //乘以其右边的乘积
            right *= a[n - 1 - i];
            System.out.print("l:"+left+" ");
            System.out.print("r:"+right+" ");
            for (int j = 0; j < n; j++) {
                System.out.print(ans[j]+ " ");
            }
            System.out.println();
        }
        return ans;
    }
}
