package conllection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetStudy {
    public static void run(){
        /*
        我们只需要存储不重复的key，并不需要存储映射的value，那么就可以使用Set
        Set用于存储不重复的元素集合，它主要提供以下几个方法：

    将元素添加进Set<E>：boolean add(E e)
    将元素从Set<E>删除：boolean remove(Object e)
    判断是否包含元素：boolean contains(Object e)
         */
        Set<String> set = new HashSet<>();
        System.out.println(set.add("abc"));//true
        System.out.println(set.add("xyz"));//true
        System.out.println(set.add("xyz"));//false,添加失败，因为元素已存在
        System.out.println(set.contains("xyz"));//true
        System.out.println(set.contains("XYZ"));//false
        System.out.println(set.remove("hello"));//false,删除失败，因为元素不存在
        System.out.println(set.size());//2,一共两个元素

        //treeSet,有序的
        Set<String> set2 = new TreeSet<>();
        set2.add("B");
        set2.add("A");
        set2.add("C");

        for (String s : set2){
            System.out.println(s);
        }
    }
}
/*
小结

Set用于存储不重复的元素集合：

    放入HashSet的元素与作为HashMap的key要求相同；
    放入TreeSet的元素与作为TreeMap的Key要求相同；

利用Set可以去除重复元素；

遍历SortedSet按照元素的排序顺序遍历，也可以自定义排序算法。
 */