package com;

import java.math.BigInteger;

public class BigIntegerStudy {

    public void run(){
        //java.math.BigInteger就是用来表示任意大小的整数。BigInteger内部用一个int[]数组来模拟一个非常大的整数：
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5));//2867971860299718107233761438093672048294900000

//        对BigInteger做运算的时候，只能使用实例方法，例如，加法运算
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780
        //BigInteger不会有范围限制，但缺点是速度比较慢
        //可以把BigInteger转换成long型
        BigInteger i3 = new BigInteger("123456789000");
        System.out.println(i3.longValue());
        System.out.println(i3.multiply(i3).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range
        //使用longValueExact()方法时，如果超出了long型的范围，会抛出ArithmeticException。
    }
}
/*
BigInteger用于表示任意大小的整数；

BigInteger是不变类，并且继承自Number；

将BigInteger转换成基本类型时可使用longValueExact()等方法保证结果准确。
 */
