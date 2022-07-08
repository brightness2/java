package generics;

public class Gen2 {

    public static void run(){

    }
}

/**编写泛型*/

//首先，按照某种类型，例如：String，来编写类：
//class Pair {
//    private String first;
//    private String last;
//    public Pair(String first,String last){
//        this.first = first;
//        this.last = last;
//    }
//    public String getFirst() {
//        return first;
//    }
//    public String getLast() {
//        return last;
//    }
//
//}

//然后，标记所有的特定类型，这里是String
//把特定类型String替换为T，并申明<T>
class Pair<T> {
    private T first;
    private T last;
    public Pair(T first,T last){
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }

    //静态方法,要特别注意，泛型类型<T>不能用于静态方法
    //静态泛型方法应该使用其他类型区分
    public static <K> Pair<K> create(K first,K last){
        return new Pair<K>(first,last);
    }
    //这样才能清楚地将静态方法的泛型类型和实例类型的泛型类型区分开

}
//熟练后即可直接从T开始编写

/**多个泛型类型*/
//泛型还可以定义多种类型。例如，我们希望Pair不总是存储两个类型一样的对象，就可以使用类型<T, K>
class Pair2<T,K> {
    private T first;
    private K last;
    public Pair2(T first,K last){
        this.first = first;
        this.last = last;
    }
    public T getFirst(){
        return first;
    }
    public K getLast(){
        return last;
    }
}
//使用的时候，需要指出两种类型：
//Pair2<String, Integer> p = new Pair<>("test", 123);

/*
小结

编写泛型时，需要定义泛型类型<T>；

静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；

泛型可以同时定义多种类型，例如Map<K, V>
 */