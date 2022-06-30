package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldStudy {

    public static void run() throws Exception{

        /**
         * Class类提供了以下几个方法来获取字段：
         *
         *     Field getField(name)：根据字段名获取某个public的field（包括父类）
         *     Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
         *     Field[] getFields()：获取所有public的field（包括父类）
         *     Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
         */
//        Class stdClass = Student.class;
//        // 获取public字段"score":
//        System.out.println(stdClass.getField("score"));
//        // 获取继承的public字段"name":
//        System.out.println(stdClass.getField("name"));
//        // 获取private字段"grade":
//        System.out.println(stdClass.getDeclaredField("grade"));
//        // 获取protected字段"age":
//        System.out.println(stdClass.getDeclaredField("age"));

        /*我们用反射获取该字段的信息，代码如下*/
        Field f = Student.class.getDeclaredField("age");
        f.getName();//age
        f.getType();//int
        int m = f.getModifiers();
        Modifier.isFinal(m);//false
        Modifier.isPublic(m);//false
        Modifier.isProtected(m);//true
        Modifier.isPrivate(m);//false
        Modifier.isStatic(m);//false

        /*获取字段值*/
        Object p = new Student("lucy",20);
        Class cls = p.getClass();
        Field f2 = cls.getField("name");
        Object value = f2.get(p);
        System.out.println(value);//lucy

        //如果是子段是private,main读取值会报 IllegalAccessException ，如果必须获取值，设置f.setAccessible(true)
        Field f3 = cls.getDeclaredField("grade");
        f3.setAccessible(true);
        Object value2 = f3.get(p);//如果不设置setAccessible(true)，  class reflection.FieldStudy cannot access a member of class reflection.Student with modifiers "private"
        System.out.println(value2);

        /*设置字段值*/
        //设置字段值是通过Field.set(Object, Object)实现的，其中第一个Object参数是指定的实例，第二个Object参数是待修改的值。示例代码如下：
        Field f4 = cls.getDeclaredField("age");
        f4.set(p,30);
        System.out.println(f4.get(p));

    }
}

class Student extends Person{
    public int score;
    private int grade;
    protected int age;

    public Student(String name,int grade){
        super(name);
        this.grade = grade;
    }
}

class Person{
    public String name;

    public Person(String name){
        this.name = name;
    }
}

/*
小结

Java的反射API提供的Field类封装了字段的所有信息：

通过Class实例的方法可以获取Field实例：getField()，getFields()，getDeclaredField()，getDeclaredFields()；

通过Field实例可以获取字段信息：getName()，getType()，getModifiers()；

通过Field实例可以读取或设置某个对象的字段，如果存在访问限制，要首先调用setAccessible(true)来访问非public字段。

通过反射读写字段是一种非常规方法，它会破坏对象的封装。
 */







