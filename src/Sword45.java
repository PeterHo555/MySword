import java.util.Arrays;

public class Sword45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        //整型数组 -> 字符串数组
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        //将lambda表达式定义的比较器传入 Array.sort() 方法
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        //将字符串数组连接为数组，速度快于 String.join("",strs);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
