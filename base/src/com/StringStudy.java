package com;

public class StringStudy {

    public  void sayHello(){
        /*
        * 在Java中，String是一个引用类型，它本身也是一个class,
        * 实际上字符串在String内部是通过一个char[]数组表示的，因此，按下面的写法也是可以的：
        * String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
        * */
        System.out.println("Hello world");
        //Java字符串的一个重要特点就是字符串不可变。这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的.
        String s = "Brightness";
        System.out.println(s);
        s = s.toUpperCase();//重新分配的局部变量
        System.out.println(s);
        //比较相等,用equals，不能用 ==
        String s1 = "Hello";
        String s2 = "Hello";
        System.out.println(s1.equals(s2));
        //忽略大小写比较 equalsIgnoreCase
        /*String类还提供了多种方法来搜索子串、提取子串。常用的方法有：*/
        //搜索
        s1.indexOf("l");//2
        s1.lastIndexOf("l");//3
        s1.startsWith("He");//true
        s1.endsWith("lo");//true
        //提取
        s2.substring(2);//llo
        s2.substring(2,4);//ll
        //去除首尾空白字符
        "  \tHello\r\n ".trim();//Hello
        //String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        //替换子串
        s1.replace('l','w');//hewwo
        String s3 = "A,,B;C ,D";
        s3.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
        //分割字符串
        String[] ss = s3.split("\\,");//{"A", "B", "C", "D"}
        //拼接字符串
        String[] s4 = {"A", "B", "C", "D"};
        String s5 = String.join("***",s4);//"A***B***C"
        System.out.println("oo-"+s5);
        //格式化字符串,%s：显示字符串；%d：显示整数；%x：显示十六进制整数；%f：显示浮点数。

        String s6 = "Hi %s,your score is %d!";
        System.out.println(s6.formatted("Lucy",100));

        //类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        //要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        //把字符串转换为boolean类型
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        //转换为char[]
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s7 = new String(cs); // char[] -> String

    }
    /*
    * 小结

    Java字符串String是不可变对象；

    字符串操作不改变原字符串内容，而是返回新字符串；

    常用的字符串操作：提取子串、查找、替换、大小写转换等；

    Java使用Unicode编码表示String和char；

    转换编码就是将String和byte[]转换，需要指定编码；

    转换为byte[]时，始终优先考虑UTF-8编码。

    * */

    public void builder(){
        /*
           为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，
           不会创建新的临时对象：
         */
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s = sb.toString();
        //StringBuilder还可以进行链式操作：
        var sb2 = new StringBuilder(1024);//java在var上是有要求的。总结起来，有以下三点很重要：（1）只能用于局部变量上；（2）声明时必须初始化；（3）不能用作方法参数。
        sb2.append("Mr ").append("Bob").append("!").insert(0,"Hello, ");
        System.out.println(sb2.toString());//Hello, Mr Bob!

        String table = "employee";
        String[] fields = { "name", "position", "salary" };
        String sql = StringStudy.buildInsertSql(table,fields);
        System.out.println(sql);
    }

    static String buildInsertSql(String table,String[] fields){
        var sql = new StringBuilder(1024);
        sql.append("INSERT INTO ")
                .append(table.trim())
                .append(" (")
                .append(String.join(",",fields))
                .append(") VALUES (?, ?, ?)");
        return  sql.toString();
    }

    static  void box(){
        /*
        包装类型非常有用，Java核心库为每种基本类型都提供了对应的包装类型：
        基本类型	对应的引用类型
        boolean	java.lang.Boolean
        byte	java.lang.Byte
        short	java.lang.Short
        int	java.lang.Integer
        long	java.lang.Long
        float	java.lang.Float
        double	java.lang.Double
        char	java.lang.Character
         */

        //基本类型转换到包装类型叫做装箱，包装类型转换到基本类型叫做拆箱
        //java中装箱与拆箱有自动处理的，在编译的时候处理
        //因为基本类型不能赋值null，包装类型可以赋值null，如果自动拆箱执行时可能会报NullPointerException：
//        Integer n = null;
//        int i = n;
        //创建新对象时，优先选用静态工厂方法而不是new操作符
        Integer i = Integer.valueOf(20);

        //在Java中，并没有无符号整型（Unsigned）的基本数据类型,无符号整型和有符号整型的转换在Java中就需要借助包装类型的静态方法完成.
        //byte是有符号整型，范围是-128~+127
        byte x = -1;
        byte y = 127;
        //byte 无符号范围 0~255
        System.out.println(Byte.toUnsignedInt(x));//255
        System.out.println(Byte.toUnsignedInt(y));//127
    }
    /*
    小结

    Java核心库提供的包装类型可以把基本类型包装为class；

    自动装箱和自动拆箱都是在编译期完成的（JDK>=1.5）；

    装箱和拆箱会影响执行效率，且拆箱时可能发生NullPointerException；

    包装类型的比较必须使用equals()；

    整数和浮点数的包装类型都继承自Number；

    包装类型提供了大量实用方法。
     */
}
