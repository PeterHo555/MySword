public class Sword43 {
    public int countDigitOne(int n) {
        int num = n;
        long i = 1;
        int s = 0;
        while(num > 0) {
            if(num % 10 == 0) // 不包含1 -9
                s += (num / 10) * i; // 修正值是 0
            System.out.println("s1:"+s);
            if(num % 10 == 1) // 包含 1 - 9的一部分
                s += (num / 10) * i + (n % i) + 1; // 修正值是(n % i) + 1
            System.out.println("s2:"+s);
            if(num % 10 > 1) // 包含1 - 9
                s += (num / 10) * i + i; // i
            System.out.println("s3:"+s);
            num = num / 10; // 比如109/10 = 10， 可以按10位的处理，因为i增量了10倍

            i = i * 10; // 每次1的个数是增加10倍
        }
        System.out.println(s);
        return s;
    }
}
