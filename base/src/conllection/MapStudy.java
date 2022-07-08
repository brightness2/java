package conllection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapStudy {
    public static void run(){
        //List是一种顺序列表，如果有一个存储学生Student实例的List，要在List中根据name查找某个指定的Student的分数，应该怎么办
        //这种就是 key-value 的数据结构,key是唯一的，如果重复put会替换原来的value
        Student s = new Student("Tom",10);
        Map<String,Student> map = new HashMap<>();
        map.put("Tom",s);//将"Tom"和Student实例映射并关联
        System.out.println(map.get("Tom"));//返回实例
        System.out.println(map.get("Bob"));//null
        //判断存在
        System.out.println(map.containsKey("Tom"));
        //遍历Map
        map.put("Lucy",new Student("Lucy",12));
        map.put("John",new Student("John",14));
        map.put("Bob",new Student("Bob",12));
        for(String key : map.keySet()){
            Student value = map.get(key);
            System.out.println(value.name + " = " + value.age);
        }
        //同时遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射
        for (Map.Entry<String,Student> entry : map.entrySet()){
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }

    public static void run2(){
        /*
        ashMap为什么能通过key直接计算出value存储的索引。相同的key对象（使用equals()判断时返回true）必须要计算出相同的索引，否则，相同的key每次取出的value就不一定对。

通过key计算索引的方式就是调用key对象的hashCode()方法，它返回一个int整数。HashMap正是通过这个方法直接定位key对应的value的索引，继而直接返回value。
         */
        /*
        因此，正确使用Map必须保证：

    作为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；

    作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：

    如果两个对象相等，则两个对象的hashCode()必须相等；
    如果两个对象不相等，则两个对象的hashCode()尽量不要相等。

即对应两个实例a和b：

    如果a和b相等，那么a.equals(b)一定为true，则a.hashCode()必须等于b.hashCode()；
    如果a和b不相等，那么a.equals(b)一定为false，则a.hashCode()和b.hashCode()尽量不要相等。

上述第一条规范是正确性，必须保证实现，否则HashMap不能正常工作。
         */
        Student2 stu = new Student2("Tom",12);
        Map<Student2,Integer> map = new HashMap<>();
        map.put(stu,100);//正确覆写了hashCode方法的对象，可作为map的key使用
        System.out.println(map.get(stu));//100
    }
}

/**实现hashCode*/
class Student2 extends  Student{

    public Student2(String name,int age){
        super(name,age);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,age);
    }
}

/*
小结

Map是一种映射表，可以通过key快速查找value。

可以通过for each遍历keySet()，也可以通过for each遍历entrySet()，直接获取key-value。

最常用的一种Map实现是HashMap。
 */