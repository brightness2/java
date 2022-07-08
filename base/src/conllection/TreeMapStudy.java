package conllection;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapStudy {
    public static void run(){
        Map<String,Integer> map = new TreeMap<>();
        map.put("orange",1);
        map.put("apple",2);
        map.put("pear",3);
        for (String key : map.keySet()){
//            System.out.println(key);
        }
        // apple, orange, pear
//        Map<Student3,Integer> map2 = new TreeMap<>(
//                new Comparator<Student3>(){
//                    public int compare(Student3 s1,Student3 s2){
//                        if(s1.score == s2.score){
//                            return 0;
//                        }
//                        return s1.score > s2.score ? -1 : 1;
//                    }
//                }
//        );
        //以下方式可以替换上面的,key的排序方式通过Comparable接口的compareTo方法实现
        Map<Student3,Integer> map2 = new TreeMap<>();
        //
        map2.put(new Student3("Tom", 77), 1);
        map2.put(new Student3("Bob", 66), 2);
        map2.put(new Student3("Lily", 99), 3);
        for (Student3 key : map2.keySet()){
            System.out.println(key.score);
            System.out.println(map2.get(key));
        }
    }
}
/*
使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
 */
/**可以实现 Comparable接口，覆写compareTo方法，实例化TreeMap就不用传入Comparator实例了*/
class Student3 implements Comparable{
    String name;
    double score;
    public Student3(String name,double score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student3 s = (Student3) o;
        return (int) (s.score - this.score);
    }
}
/*
小结

SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；

作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；

要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。
 */