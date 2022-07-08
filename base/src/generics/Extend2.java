package generics;

public class Extend2 {
    public static void run(){
        /**extends 通配符*/
        //extends通配符的作用：当一个方法的参数使用extends通配符，说明当前方法对参数变量引用的对象只进行读操作，而不进行修改操作
        A<Integer> a = new A<>(123,456);
//        int n = add(a);//编译错误
        int n = add2(a);//编译成功
        System.out.println(n);
        System.out.println(a.getFirst());
    }
    //参数类型A<Number>，参数的泛型只能是Number类型，子类也不行
    static  int add(A<Number> a){
        Number first = a.getFirst();
        Number last = a.getLast();
        return  first.intValue() + last.intValue();
    }
    //参数类型A<? extends Number>，参数的泛型只能是Number类型或其子类
    static int add2(A<? extends Number> a){
        Number first = a.getFirst();
        Number last = a.getLast();
//        a.setFirst(Integer.valueOf(first.intValue()) + 100);/**这里报错，通配符作为方法参数时，方法内部无法调用传入Number引用的方法（null除外）*/

        return  first.intValue() + last.intValue();
    }
}
//使用extends限定T类型
class A<T extends Number>{
    private T first;
    private T last;
    public A(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }

    public void setFirst(T first){
        this.first = first;
    }
}

/*
小结

使用类似<? extends Number>通配符作为方法参数时表示：

    方法内部可以调用获取Number引用的方法，例如：Number n = obj.getFirst();；

    方法内部无法调用传入Number引用的方法（null除外），例如：obj.setFirst(Number n);。

即一句话总结：使用extends通配符表示可以读，不能写。

使用类似<T extends Number>定义泛型类时表示：

    泛型类型限定为Number以及Number的子类。

 */