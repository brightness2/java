package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class AnnotationStudy {

    public static void run(){
//        什么是注解（Annotation）？注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”
        /**
         * Java的注解可以分为三类：
         *    1、第一类是由编译器使用的注解
         *        @Override：让编译器检查该方法是否正确地实现了覆写；
         *        @SuppressWarnings：告诉编译器忽略此处代码产生的警告。
         *    2、第二类是由工具处理.class文件使用的注解
         *        比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能
         *    3、第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解
         *        例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用
         */

        /***RUNTIME类型的注解不但要使用，还经常需要编写***/
        /*
        判断某个注解是否存在于Class、Field、Method或Constructor：

    Class.isAnnotationPresent(Class)
    Field.isAnnotationPresent(Class)
    Method.isAnnotationPresent(Class)
    Constructor.isAnnotationPresent(Class)

         */
        /*
        使用反射API读取Annotation：

    Class.getAnnotation(Class)
    Field.getAnnotation(Class)
    Method.getAnnotation(Class)
    Constructor.getAnnotation(Class)

         */

        Person p = new Person("李四","广东省广州市越秀区");
        try{
            AnnotationStudy.check(p);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //    自己编写代码来使用注解
    static void  check(Person person) throws IllegalArgumentException,ReflectiveOperationException{
        // 遍历所有Field
        for(Field field : person.getClass().getFields()){
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在
            if(range != null){
                // 获取Field的值:
                Object value = field.get(person);
                // 如果值是String:
                if(value instanceof  String){
                    String s = (String) value;
                    // 判断值是否满足@Range的min/max:
                    if(s.length() < range.min() || s.length() > range.max()){
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }
    }
    //这样一来，我们通过@Range注解，配合check()方法，就可以完成Person实例的检查。注意检查逻辑完全是我们自己编写的，JVM不会自动给注解添加任何额外的逻辑。
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min() default 0;
    int max() default 255;
}

class Person{

    @Range(min=1, max=5)
    public String name;

    @Range(max=6)
    public String city;

    public String getName(){
        return this.name;
    }

    public Person(String name,String city){
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString(){
        return "person";
    }


}

/*
小结

注解（Annotation）是Java语言用于工具处理的标注：

注解可以配置参数，没有指定配置的参数使用默认值；

如果参数名称是value，且只有一个参数，那么可以省略参数名称。
 */
