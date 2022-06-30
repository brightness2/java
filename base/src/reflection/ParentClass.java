package reflection;

public class ParentClass {

    public static void fun(){
        //获取父类的Class,除Object外，其他任何非interface的Class都必定存在一个父类类型
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);//class java.lang.Number
        //获取interface,getInterfaces()只返回当前类直接实现的接口类型，
        Class[] is = i.getInterfaces();
        for(Class j : is){
            System.out.println(j);
        }
        //判断一个向上转型是否成立，可以调用isAssignableFrom()
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
    }
}
/*
小结

通过Class对象可以获取继承关系：

    Class getSuperclass()：获取父类类型；
    Class[] getInterfaces()：获取当前类实现的所有接口。

通过Class对象的isAssignableFrom()方法可以判断一个向上转型是否可以实现。
 */
