package generics;

public class TypeErasure {
    public static void run(){
        /**
         * 泛型是一种类似”模板代码“的技术，不同语言的泛型实现方式不一定相同。
         *
         * Java语言的泛型实现方式是擦拭法（Type Erasure）。
         *
         * 所谓擦拭法是指，虚拟机对泛型其实一无所知，所有的工作都是编译器做的
         */
        /*
        Java泛型的局限
        局限一：<T>不能是基本类型，例如int，因为实际类型是Object，Object类型无法持有基本类型
        Pair<int> p = new Pair<>(1, 2); // compile error!

        局限二：无法取得带泛型的Class.
        Pair<String> p1 = new Pair<>("Hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1==c2); // true
        System.out.println(c1==Pair.class); // true
        //因为T是Object，我们对Pair<String>和Pair<Integer>类型获取Class时，获取到的是同一个Class，也就是Pair类的Class

        局限三：无法判断带泛型的类型
        Pair<Integer> p = new Pair<>(123, 456);
        // Compile error:
        if (p instanceof Pair<String>) {
        }

        原因和前面一样，并不存在Pair<String>.class，而是只有唯一的Pair.class

        局限四：不能实例化T类型
        public class Pair<T> {
            private T first;
            private T last;
            public Pair() {
                // Compile error:
                first = new T();
                last = new T();
            }
        }

        上述代码无法通过编译，因为构造方法的两行语句：

        first = new T();
        last = new T();

        擦拭后实际上变成了：

        first = new Object();
        last = new Object();

        要实例化T类型，我们必须借助额外的Class<T>参数
        public class Pair<T> {
            private T first;
            private T last;
            public Pair(Class<T> clazz) {
                first = clazz.newInstance();
                last = clazz.newInstance();
            }
        }
        上述代码借助Class<T>参数并通过反射来实例化T类型，使用的时候，也必须传入Class<T>
        Pair<String> pair = new Pair<>(String.class);
         */
    }
}
