package generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Extend {
    public static void run(){
        /**泛型继承*/
        //获取父类的泛型类型
        Class<Cat> clazz = Cat.class;
        Type t = clazz.getGenericSuperclass();
        if(t instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments();// 可能有多个泛型类型
            Type firstType = types[0];//  取第一个泛型类型
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass);
        }

    }
}

class Animal<T>{
    private T first;
    private T last;
    public Animal(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}

class Cat extends Animal<String>{
    public Cat(String first, String last) {
        super(first, last);
    }
}

/*
小结

Java的泛型是采用擦拭法实现的；

擦拭法决定了泛型<T>：

    不能是基本类型，例如：int；
    不能获取带泛型类型的Class，例如：Pair<String>.class；
    不能判断带泛型类型的类型，例如：x instanceof Pair<String>；
    不能实例化T类型，例如：new T()。

泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；

子类可以获取父类的泛型类型<T>。
 */