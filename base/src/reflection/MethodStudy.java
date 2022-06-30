package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodStudy {

    public static void run() throws Exception{
        /**
         * 通过Class实例获取所有Method信息
         *
         * Method getMethod(name, Class...)：获取某个public的Method（包括父类）
         * Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
         * Method[] getMethods()：获取所有public的Method（包括父类）
         * Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）
         */

        /*获取方法*/
        Class catCls = Cat.class;
//        System.out.println(catCls.getMethod("getAge"));
//        System.out.println(catCls.getMethod("getName"));
//        System.out.println(Arrays.stream(catCls.getMethods()).toList());

        /**
         * 一个Method对象包含一个方法的所有信息：
         *
         *     getName()：返回方法名称，例如："getScore"；
         *     getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
         *     getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
         *     getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义
         */
       //调用示例方法
        Cat cat1 = new Cat(10.4);
        Method m2 = Cat.class.getDeclaredMethod("getAge", int.class);
        int age = (int) m2.invoke(cat1,4);
//        System.out.println(age);
        //调用静态方法,调用静态方法时，由于无需指定实例对象,第一个参数永远为null
        Method m3 = Cat.class.getDeclaredMethod("printName");
//        m3.invoke(null);

        //调用非public方法,直接对其调用将得到一个IllegalAccessException,通过Method.setAccessible(true)允许其调用
        Method m4 = Cat.class.getDeclaredMethod("getWeight");
        m4.setAccessible(true);
        double weight = (double) m4.invoke(cat1);
//        System.out.println(weight);

        //调用构造方法
        /**
         * 通过Class实例获取Constructor的方法如下：
         *
         *     getConstructor(Class...)：获取某个public的Constructor；
         *     getDeclaredConstructor(Class...)：获取某个Constructor；
         *     getConstructors()：获取所有public的Constructor；
         *     getDeclaredConstructors()：获取所有Constructor。
         */
        Constructor cons1 = Cat.class.getConstructor(double.class);
        Cat cat2 = (Cat) cons1.newInstance(30.2);
        System.out.println(cat2);
    }
}
class Cat extends Animal{
    protected double weight;
    public Cat(double weight){
        this.weight =weight;
    }

    public int getAge(int age){
        return age;
    }

    protected double getWeight(){
        return this.weight;
    }

    public static void printName(){
        System.out.println("Tom");
    }
}

class  Animal{

    public String getName(){
        return "Animal";
    }
}

/*
小结

Java的反射API提供的Method对象封装了方法的所有信息：

通过Class实例的方法可以获取Method实例：getMethod()，getMethods()，getDeclaredMethod()，getDeclaredMethods()；

通过Method实例可以获取方法信息：getName()，getReturnType()，getParameterTypes()，getModifiers()；

通过Method实例可以调用某个对象的方法：Object invoke(Object instance, Object... parameters)；

通过设置setAccessible(true)来访问非public方法；

通过反射调用方法时，仍然遵循多态原则。

Constructor对象封装了构造方法的所有信息；

通过Class实例的方法可以获取Constructor实例：getConstructor()，getConstructors()，getDeclaredConstructor()，getDeclaredConstructors()；

通过Constructor实例可以创建一个实例对象：newInstance(Object... parameters)； 通过设置setAccessible(true)来访问非public构造方法。
 */