package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void run(){
        //一个最简单的动态代理实现如下
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if(method.getName().equals("morning")){
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };

        Hello hello = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),//传入classLoader
                new Class[] { Hello.class },// 传入要实现的接口
                handler// 传入处理调用方法的InvocationHandler
        );
        hello.morning("Bob");

        /**
         * 在运行期动态创建一个interface实例的方法如下：
         *
         *     定义一个InvocationHandler实例，它负责实现接口的方法调用；
         *     通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
         *         使用的ClassLoader，通常就是接口类的ClassLoader；
         *         需要实现的接口数组，至少需要传入一个接口进去；
         *         用来处理接口方法调用的InvocationHandler实例。
         *     将返回的Object强制转型为接口。
         */
    }
}

interface  Hello{
    void morning(String name);
}
/*
小结

Java标准库提供了动态代理功能，允许在运行期动态创建一个接口的实例；

动态代理是通过Proxy创建代理对象，然后将接口方法“代理”给InvocationHandler完成的。
 */