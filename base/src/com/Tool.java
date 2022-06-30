package com;

import java.security.SecureRandom;
import java.util.Random;

public class Tool {

    public void run(){

        /*Math,数学计算的*/
        Math.abs(-100); // 100
        Math.abs(-7.8); // 7.8
        Math.max(100, 99); // 100
        Math.min(1.2, 2.3); // 1.2

//        计算xy次方
        Math.pow(2, 10); // 2的10次方=1024
//        计算√x
        Math.sqrt(2); // 1.414...
//        计算ex次方
        Math.exp(2); // 7.389...

        /*生成区间数*/
        double x = Math.random(); // x的范围是[0,1)
        double min = 10;
        double max = 50;
        double y = x * (max - min) + min; // y的范围是[10,50)
        long n = (long) y; // n的范围是[10,50)的整数
        System.out.println(y);
        System.out.println(n);

        //Random用来创建伪随机数
        Random r = new Random();
        r.nextInt(); // 2071575453,每次都不一样
        r.nextInt(10); // 5,生成一个[0,10)之间的int
        r.nextLong(); // 8811649292570369305,每次都不一样
        r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
        r.nextDouble(); // 0.3716...生成一个[0,1)之间的double

        //SecureRandom ,用来创建安全的随机数
        SecureRandom sr = new SecureRandom();
        System.out.println(sr.nextInt(100));
    }
}
/*
小结

Java提供的常用工具类有：

    Math：数学计算

    Random：生成伪随机数

    SecureRandom：生成安全的随机数
 */