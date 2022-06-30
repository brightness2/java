package com;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalStudy {

    public void run(){
//        和BigInteger类似，BigDecimal可以表示一个任意大小且精度完全准确的浮点数
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489
        //BigDecimal用scale()表示小数位数，例如
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0
        //去掉小数后面的0
        BigDecimal d4 = new BigDecimal("123.4500");
        BigDecimal d5 = d4.stripTrailingZeros();
        System.out.println(d4.scale());//4
        System.out.println(d5.scale());//2,因为去掉了00

        //对一个BigDecimal设置它的scale,按照指定的方法进行四舍五入或者直接截断
        BigDecimal d6 = new BigDecimal("123.456789");
        BigDecimal d7 = d6.setScale(4, RoundingMode.HALF_UP);//四舍五入，123.4568
        BigDecimal d8 = d6.setScale(4,RoundingMode.DOWN);//直接截断，123.4567

        //对BigDecimal做加、减、乘时，精度不会丢失，但是做除法时，存在无法除尽的情况，这时，就必须指定精度以及如何进行截断：
        //除法必须进行精度设置和截断
        BigDecimal d9 = new BigDecimal("123.456");
        BigDecimal d10 = new BigDecimal("23.456789");
        BigDecimal d11 = d9.divide(d10,10,RoundingMode.HALF_UP);//保留10位小数并四舍五入
//        BigDecimal d12 = d9.divide(d10);//报错：ArithmeticException，因为除不尽
//        System.out.println(d11);//5.2631244626

        //可以对BigDecimal做除法的同时求余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]);//102.0
        System.out.println(dr[1]);//0.105

        //判断两个BigDecimal是否是整数倍数
        BigDecimal n2 = new BigDecimal("12.75");
        BigDecimal m2 = new BigDecimal("0.15");
        BigDecimal[] dr2 = n2.divideAndRemainder(m2);
        if(dr2[1].signum() == 0){
            System.out.println("n是m的整数倍");
        }

        //比较BigDecimal,使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等：
        BigDecimal n3 = new BigDecimal("123.456");
        BigDecimal m3 = new BigDecimal("123.45600");
        System.out.println(n3.equals(m3));//false,因为scale不同
        System.out.println(n3.equals(m3.stripTrailingZeros()));//true,因为m3去除尾部0后scale变为3
        //所以使用compareTo()比较,返回负数、正数和0，分别表示小于、大于和等于
        System.out.println(n3.compareTo(m3) == 0);
    }
}
/*
小结

BigDecimal用于表示精确的小数，常用于财务计算；

比较BigDecimal的值是否相等，必须使用compareTo()而不能使用equals()。
 */
