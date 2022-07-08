package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gen {

    public static void run(){

//        Test.test1();
//        Test.test2();
        Test.test3();
    }

}

class Test{
    static void test1(){
        //使用ArrayList时，如果不定义泛型类型时，泛型类型实际上就是Object
        List list = new ArrayList();
        list.add("Hello");
        list.add("World");
        String first = (String) list.get(0);
        String second = (String) list.get(1);
        //此时，只能把<T>当作Object使用，没有发挥泛型的优势。
    }

    static void test2(){

        //当我们定义泛型类型<String>后，List<T>的泛型接口变为强类型List<String>
        List<String>  list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        //无强制转型
        String first =  list.get(0);
        String second =  list.get(1);
    }

    static void test3(){
        Person[] ps = new Person[] {
                new Person("Bob",20),
                new Person("Alice",30),
                new Person("Lily",12),
        };
        //进行排序
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));

    }
}

//泛型接口使用

class Person implements Comparable<Person>{
    String name;
    int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    //实现Comparable的排序功能，
    @Override
    public int compareTo(Person other){
        //按 name 排序
        return  this.name.compareTo(other.name);
        //按 age 排序，正序
//        return  this.age - other.age;
        //按 age 排序，反序
//        return  other.age - this.age;

    }

    public String toString(){
        return  this.name + ":" + this.age;
    }

}
