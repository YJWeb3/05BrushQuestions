package com.wclass.structalgorithm.sort_14;

/**
 * @program: StructAlgorithm
 * @ClassName q3_fibonacci
 * @description:
 * @author: W哥
 * @create: 2024-09-04-00-33
 * @Version 1.0
 **/
public class q3_fibonacci {


    // 方法一：迭代相加（推荐使用）
    public int Fibonacci01(int n) {
        //从0开始，第0项是0，第一项是1
        if(n <= 1)
            return n;
        int res = 0;
        int a = 0;
        int b = 1;
        //因n=2时也为1，初始化的时候把a=0，b=1
        for (int i = 2; i <= n; i++){
            //第三项开始是前两项的和,然后保留最新的两项，更新数据相加
            res = (a + b);
            a = b;
            b = res;
        }
        return res;
    }

    // 方法二：递归法（扩展思路）
    public int Fibonacci02(int n) {
        //从0开始，第0项是0，第一项是1
        if (n <= 1)
            return n;
        else{
            //根据公式递归调用函数
            return Fibonacci02(n - 1) + Fibonacci02(n - 2);
        }
    }

    // 方法三：动态规划(扩展思路)
    public int Fibonacci03(int n) {
        //从0开始，第0项是0，第一项是1
        if(n <= 1)
            return n;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        //依次相加
        for (int i = 2; i <= n; i++)
            fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];
    }
}
