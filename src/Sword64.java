public class Sword64 {
    //Java 中，为构成语句，需加一个辅助布尔量 xx ，否则会报错；
    //Java 中，开启递归函数需改写为 sumNums(n - 1) > 0 ，此整体作为一个布尔量输出，否则会报错；
    //初始化变量 resres 记录结果。（ Java 可使用第二栏的简洁写法，不用借助变量 resres ）。
    public int sumNums(int n) {
        // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
