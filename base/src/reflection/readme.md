# 反射
反射就是Reflection，Java的反射是指程序在运行期可以拿到一个对象的所有信息

除了int等基本类型外，Java的其他类型全部都是class（包括interface）

而class是由JVM在执行过程中动态加载的。JVM在第一次读取到一种class类型时，将其加载进内存。
每加载一种class，JVM就为其创建一个Class类型的实例，并关联起来

以String类为例，当JVM加载String类时，它首先读取String.class文件到内存，然后，为String类创建一个Class实例并关联起来：

Class cls = new Class(String);

这个Class实例是JVM内部创建的，如果我们查看JDK源码，可以发现Class类的构造方法是private，只有JVM能创建Class实例，我们自己的Java程序是无法创建Class实例的。

由于JVM为每个加载的class创建了对应的Class实例，并在实例中保存了该class的所有信息，包括类名、包名、父类、实现的接口、所有方法、字段等，因此，如果获取了某个Class实例，我们就可以通过这个Class实例获取到该实例对应的class的所有信息。

这种通过Class实例获取class信息的方法称为反射（Reflection）。


## 动态加载
JVM在执行Java程序的时候，并不是一次性把所有用到的class全部加载到内存，而是第一次需要用到class时才加载

## 访问字段
```
Class类提供了以下几个方法来获取字段：

    Field getField(name)：根据字段名获取某个public的field（包括父类）
    Field getDeclaredField(name)：根据字段名获取当前类的某个field（不包括父类）
    Field[] getFields()：获取所有public的field（包括父类）
    Field[] getDeclaredFields()：获取当前类的所有field（不包括父类）
```

```
一个Field对象包含了一个字段的所有信息：

    getName()：返回字段名称，例如，"name"；
    getType()：返回字段类型，也是一个Class实例，例如，String.class；
    getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义
```

```
Class类提供了以下几个方法来获取Method
    Method getMethod(name, Class...)：获取某个public的Method（包括父类）
    Method getDeclaredMethod(name, Class...)：获取当前类的某个Method（不包括父类）
    Method[] getMethods()：获取所有public的Method（包括父类）
    Method[] getDeclaredMethods()：获取当前类的所有Method（不包括父类）

```

```
一个Method对象包含一个方法的所有信息：

    getName()：返回方法名称，例如："getScore"；
    getReturnType()：返回方法返回值类型，也是一个Class实例，例如：String.class；
    getParameterTypes()：返回方法的参数类型，是一个Class数组，例如：{String.class, int.class}；
    getModifiers()：返回方法的修饰符，它是一个int，不同的bit表示不同的含义
```

```
通过Class实例获取Constructor的方法如下：

    getConstructor(Class...)：获取某个public的Constructor；
    getDeclaredConstructor(Class...)：获取某个Constructor；
    getConstructors()：获取所有public的Constructor；
    getDeclaredConstructors()：获取所有Constructor。

```

## 动态代理
先定义了接口Hello，但是我们并不去编写实现类，而是直接通过JDK提供的一个Proxy.newProxyInstance()创建了一个Hello接口对象。这种没有实现类但是在运行期动态创建了一个接口对象的方式，我们称为动态代码。JDK提供的动态创建接口对象的方式，就叫动态代理。

```
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
```

在运行期动态创建一个interface实例的方法如下：
```
    定义一个InvocationHandler实例，它负责实现接口的方法调用；
    通过Proxy.newProxyInstance()创建interface实例，它需要3个参数：
        使用的ClassLoader，通常就是接口类的ClassLoader；
        需要实现的接口数组，至少需要传入一个接口进去；
        用来处理接口方法调用的InvocationHandler实例。
    将返回的Object强制转型为接口。
```
