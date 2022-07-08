package conllection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class ListStudy {
    public static void run(){
        //最简单的集合,数组
        String[] ss = new String[10];
        /*
        数组有如下限制：
            数组初始化后大小不可变；
            数组只能按索引顺序存取;
            所以需要其它集合
         */
        /*
        java.util包主要提供了以下三种类型的集合：

    List：一种有序列表的集合，例如，按索引排列的Student的List；
    Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
    Map：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。
         */
        List1.run();
        List1.run2();
    }
}
/*
Java集合的设计有几个特点：一是实现了接口和实现类相分离，例如，有序表的接口是List，具体的实现类有ArrayList，LinkedList等，二是支持泛型，
我们可以限制在一个集合中只能放入同一种数据类型的元素
 */
class List1{
    static void run(){
        //Java的集合类定义在java.util包中，支持泛型，主要提供了3种集合类，包括List，Set和Map。Java集合使用统一的Iterator遍历，尽量不要使用遗留接口。

        ArrayList<String> sl = new ArrayList<>();
        sl.add("a");
        sl.add("b");
        sl.add("c");
        sl.add("d");
        sl.add(null);
        System.out.println(sl.size());

        //List接口提供的of()方法，根据给定元素快速创建List
        List<Integer> li = List.of(1,2,3);
       //遍历List，方式一
        for (int i = 0; i < li.size(); i++) {
            Integer n = li.get(i);
//            System.out.println(n);
        }
        //遍历List，方式二,推荐
        for (Iterator<Integer> it = li.iterator();it.hasNext();){
            Integer n = it.next();
//            System.out.println(n);
        }
        //以上遍历方式可以简写,for each
        //实现了Iterable接口的集合类都可以直接用for each循环来遍历
        for(Integer n : li){
//            System.out.println(n);
        }
        //List和Array转换
        List<String> list = List.of("apple","pear","banna");
        Object[] array = list.toArray();//这种方法会丢失类型信息，所以实际应用很少

        String[] array2 = list.toArray(new String[list.size()]);//给toArray(T[])传入一个类型相同的Array,


        Integer[] nums = {1,2,3};
        List<Integer> numList = List.of(nums);//调用List.of()，它返回的是一个只读List,对只读List调用add()、remove()方法会抛出UnsupportedOperationException。



    }

    static void run2(){
       //boolean contains(Object o)方法来判断List是否包含某个指定元素
       List<String> ss = List.of("A","B","C");
        System.out.println(ss.contains("B"));//true
        System.out.println(ss.contains("X"));//false
        System.out.println(ss.indexOf(new String("B")));//1
        System.out.println(ss.indexOf("X"));//-1
//        我们之所以能正常放入String、Integer这些对象，是因为Java标准库定义的这些类已经正确实现了equals()方法,否则，放进去的实例，查找不到
        List<Person> ps = List.of(
                new Person("Lucy"),
                new Person("John"),
                new Person("Tom")
        );
        System.out.println(ps.contains(new Person("Lucy")));//false,因为没有正确覆写equals方法
        List<Student> stu = List.of(
                new Student("Lucy",18),
                new Student("John",20),
                new Student("Tom",16)
        );
        System.out.println(stu.contains(new Student("Lucy",18)));//true,应为正确覆写了equals方法，name与age相同时，返回true
        System.out.println(stu.indexOf(new Student("Tom",16)));//2
    }
}

class Person{
    String name;
    public Person(String name){
        this.name = name;
    }
}

class Student extends Person{
    int age;
   public Student(String name,int age){
       super(name);
       this.age = age;
   }

   /*
   如何正确编写equals()方法？equals()方法要求我们必须满足以下条件：

    自反性（Reflexive）：对于非null的x来说，x.equals(x)必须返回true；
    对称性（Symmetric）：对于非null的x和y来说，如果x.equals(y)为true，则y.equals(x)也必须为true；
    传递性（Transitive）：对于非null的x、y和z来说，如果x.equals(y)为true，y.equals(z)也为true，那么x.equals(z)也必须为true；
    一致性（Consistent）：对于非null的x和y来说，只要x和y状态不变，则x.equals(y)总是一致地返回true或者false；
    对null的比较：即x.equals(null)永远返回false。

    */
    public boolean equals(Object o){
        if(o instanceof Student){
            Student s = (Student) o;
//            boolean nameEquals = false;
//            if(this.name == null && s.name == null){
//                nameEquals = true;
//            }
//            if(this.name != null){
//                //对于引用字段比较，我们使用equals()，对于基本类型字段的比较，我们使用==。
//                return this.name.equals(s.name);
//            }
            return Objects.equals(this.name,s.name) && this.age == s.age;
        }
        return false;
    }
    /**
    我们总结一下equals()方法的正确编写方法：

    先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
    用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
    对引用类型用Objects.equals()比较，对基本类型直接用==比较。

使用Objects.equals()比较两个引用类型是否相等的目的是省去了判断null的麻烦。两个引用类型都是null时它们也是相等的。

如果不调用List的contains()、indexOf()这些方法，那么放入的元素就不需要实现equals()方法。
     */
}