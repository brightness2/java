package com;

public class RecordStudy {
   public void run(){
       Point2 p2 = Point2.of(123,456);
       System.out.println(p2.x());
       System.out.println(p2.y());
       System.out.println(p2);
   }

}
/*
记录类
定义class时使用final，无法派生子类；
每个字段使用final，保证创建实例后无法修改任何字段
 */

class Point{
    private final int x;
    private final int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public int x(){
        return  this.x;
    }
    public int y(){
        return  this.y;
    }
    public String toString() {
        return String.format("Point[x=%s, y=%s]", x, y);
    }

}
//以上就是记录类的定义，这些代码写起来都非常简单，但是很繁琐。
//从Java 14开始，引入了新的Record类，把上述Point类改写为Record类
 record Point2(int x,int y){
    //如果需要校验参数,这个方法被称为Compact Constructor，编译后会合并到构造方法中，并合并在构造方法的代码前
    /*
        编译后
        public Point2(int x, int y) {
            // 这是我们编写的Compact Constructor:
            if (x < 0 || y < 0) {
                throw new IllegalArgumentException();
            }
            // 这是编译器继续生成的赋值代码:
            this.x = x;
            this.y = y;
        }
     */
    public Point2{
        if(x<0||y<0){
            throw new IllegalArgumentException();
        }
    }

//    可以添加静态方法，of()方法，用来创建Point,可以写出更简洁的代码,Point2.of(123,456)
    public static Point2 of(){
        return new Point2(0,0);
    }

    public static Point2 of(int x,int y){
        return new Point2(x,y);
    }
}