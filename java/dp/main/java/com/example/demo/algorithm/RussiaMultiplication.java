package com.example.demo.algorithm;

/**
 * Created by wangshu on 2019/8/12.
 *
 * 俄式乘法又称俄国农夫乘法,用于正整数的一般乘法
 *
 * a是偶数：a * b = (a/2) * (2*b)
 * a是奇数：a * b = ((a-1)/2) * (2*b) + b
 * 直到 a = 1
 *
 */
public class RussiaMultiplication {
    private static int[] s = new int[100];
    public static void main(String[] args) throws Exception {
        int a = 50;
        System.out.println(a<<1);
        System.out.println(a>>1);
        int sum =0;
        int n = 100;
        long start = System.currentTimeMillis();
        for(int k=0;k<n;++k){
            System.out.println(sum = menthod(10001,23005689,0));
            for (int i=0;i<s.length && s[i] != 0;++i){
                sum += s[i];
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("耗时 = " + (end - start));
        start = System.currentTimeMillis();
        for(int k=0;k<n;++k) {
            System.out.println(10001 * 23005689);
        }
        end = System.currentTimeMillis();
        System.out.println("耗时 = " + (end - start));

    }
    public static int menthod(int a,int b,int i) throws Exception {
        if(a == 1 || b == 1){
            return a == 1 ? b : a;
        }
        if(a % 2 == 0 ){
            a = a >> 1;
            b = b << 1;
            return menthod(a,b,i);
        }
        if(a % 2 == 1){
            a = (a-1) >> 1;
            s[i] = b;//额外的空间存储临时b
            ++i;
            b = (b << 1);
            return menthod(a,b,i);
        }
        throw new Exception("");
    }
}
