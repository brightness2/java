package generics;

public class Sup {
    public static void run(){
            /**super通配符*/
            //使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。
            B<Number> b1 = new B<>(12.3,3);
            B<Integer> b2 = new B<>(123,456);
            setSame(b1,15);
            setSame(b2,26);
        System.out.println(b1.getFirst());
        System.out.println(b2.getFirst());
        /**无限定通配符*/
        //即只定义一个?
        /*
        因为<?>通配符既没有extends，也没有super，因此：

    不允许调用set(T)方法并传入引用（null除外）；
    不允许调用T get()方法并获取T引用（只能获取Object引用）。

换句话说，既不能读，也不能写，那只能做一些null判断
<?>通配符有一个独特的特点，就是：Pair<?>是所有Pair<T>的超类
         */
    }
    //参数类型B<? super Integer>，参数的泛型只能是Integer类型或其父类
    static void setSame(B<? super Integer> b,Integer n){
//        Integer n = b.getFirst();//无法使用Integer类型来接收getFirst()的返回值,返回值可能是Integer的父类，无法转型到Integer
        b.setFirst(n);
        b.setLast(n);
    }
}

class B<T>{
    private T first;
    private T last;
    public B(T first, T last) {
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

    public void setLast(T last) {
        this.last = last;
    }
}

/*
我们再回顾一下extends通配符。作为方法参数，<? extends T>类型和<? super T>类型的区别在于：

    <? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；

    <? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。

一个是允许读不允许写，另一个是允许写不允许读。
 */

/*
PECS原则

何时使用extends，何时使用super？为了便于记忆，我们可以用PECS原则：Producer Extends Consumer Super。

即：如果需要返回T，它是生产者（Producer），要使用extends通配符；如果需要写入T，它是消费者（Consumer），要使用super通配符。
 */

/*
小结

使用类似<? super Integer>通配符作为方法参数时表示：

    方法内部可以调用传入Integer引用的方法，例如：obj.setFirst(Integer n);；

    方法内部无法调用获取Integer引用的方法（Object除外），例如：Integer n = obj.getFirst();。

即使用super通配符表示只能写不能读。

使用extends和super通配符要遵循PECS原则。

无限定通配符<?>很少使用，可以用<T>替换，同时它是所有<T>类型的超类。
 */