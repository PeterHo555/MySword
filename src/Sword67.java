public class Sword67 {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0)
            return 0;
        // limit = 214748364
        int res = 0, limit = Integer.MAX_VALUE / 10;
        System.out.println(limit);
        int i = 1, sign = 1;
        // 若首字符为'-'，标记符号位为-1
        if(c[0] == '-')
            sign = -1;
            // 其余情况下，只要不是'+'，就都是非法，标记为0
        else if(c[0] != '+')
            i = 0;
        // 遍历剩余字符数组的每一位。
        for(int j = i; j < c.length; j++) {
            // 若char数组中含有非法字符，break
            if(c[j] < '0' || c[j] > '9')
                break;
            // 结果需要小于2147483647，退一位计算比较方便
            if(res > limit || res == limit && c[j] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
