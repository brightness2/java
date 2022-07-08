# 注解
什么是注解（Annotation）？注解是放在Java源码的类、方法、字段、参数前的一种特殊“注释”

参考链接 https://www.liaoxuefeng.com/wiki/1252599548343744/1265102026065728
## Java的注解可以分为三类

第一类是由编译器使用的注解，例如：

    @Override：让编译器检查该方法是否正确地实现了覆写；
    @SuppressWarnings：告诉编译器忽略此处代码产生的警告。

这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。

第二类是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。

第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用（这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。

```
定义一个注解时，还可以定义配置参数。配置参数可以包括：

    所有基本类型；
    String；
    枚举类型；
    基本类型、String、Class以及枚举的数组。

```

## 定义注解
```
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
//注解的参数类似无参数方法，可以用default设定一个默认值（强烈推荐）。最常用的参数应当命名为value
```

//元注解
有一些注解可以修饰其他注解，这些注解就称为元注解（meta annotation）,Java标准库已经定义了一些元注解，我们只需要使用元注解，通常不需要自己去编写元注解

@Target

最常用的元注解是@Target。使用@Target可以定义Annotation能够被应用于源码的哪些位置：
```
    类或接口：ElementType.TYPE；
    字段：ElementType.FIELD；
    方法：ElementType.METHOD；
    构造方法：ElementType.CONSTRUCTOR；
    方法参数：ElementType.PARAMETER。

```
例如，定义注解@Report可用在方法上，我们必须添加一个@Target(ElementType.METHOD)
```
@Target(ElementType.METHOD)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}
```

@Retention

另一个重要的元注解@Retention定义了Annotation的生命周期
```

    仅编译期：RetentionPolicy.SOURCE；
    仅class文件：RetentionPolicy.CLASS；
    运行期：RetentionPolicy.RUNTIME。
    如果@Retention不存在，则该Annotation默认为CLASS
```

