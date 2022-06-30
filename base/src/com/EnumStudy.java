package com;

public class EnumStudy {

    public  void run(){
        System.out.println(Weekday.SUN);//星期日,Weekday类的实例,打印类，直接转换字符串输出，执行toString方法
        String s = Weekday.TUE.name();//常量名
        int n = Weekday.TUE.ordinal();//常量的顺序，从0开始计数

        System.out.println(Weekday.THU.dayValue+"---"+Weekday.TUE.toString());

        Weekday day = Weekday.WED;
        switch (day){
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("work day");
                break;
            case SAT:
            case SUN:
                System.out.println("day off");
            default:
                System.out.println("cannot process");
        }
    }
}

/*
定义枚举类
因为enum是一个class，每个枚举的值都是class实例
 */
enum  Weekday{
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final   int dayValue;
    private final   String dayString;

    private  Weekday(int dayValue,String dayString){
        this.dayValue = dayValue;
        this.dayString = dayString;
    }
    @Override
    public String toString(){
        return  this.dayString;
    }
}

enum Color{
    RED,GREEN,BLUE;
}
/*
通过enum定义的枚举类，和其他的class有什么区别？

答案是没有任何区别。enum定义的类型就是class，只不过它有以下几个特点：

    定义的enum类型总是继承自java.lang.Enum，且无法被继承；
    只能定义出enum的实例，而无法通过new操作符创建enum的实例；
    定义的每个实例都是引用类型的唯一实例；
    可以将enum类型用于switch语句。

 */

/*
Java使用enum定义枚举类型，它被编译器编译为final class Xxx extends Enum { … }；

通过name()获取常量定义的字符串，注意不要使用toString()；

通过ordinal()返回常量定义的顺序（无实质意义）；

可以为enum编写构造方法、字段和方法

enum的构造方法要声明为private，字段强烈建议声明为final；

enum适合用在switch语句中。
 */