package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
小结

Java使用@interface定义注解：

可定义多个参数和默认值，核心参数使用value名称；

必须设置@Target来指定Annotation可以应用的范围；

应当设置@Retention(RetentionPolicy.RUNTIME)便于运行期读取该Annotation。

注解定义后也是一种class，所有的注解都继承自java.lang.annotation.Annotation
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {
    int type() default 0;
    String level() default "info";
    String value() default "";
}

/*
Java的注解本身对代码逻辑没有任何影响。根据@Retention的配置：

    SOURCE类型的注解在编译期就被丢掉了；
    CLASS类型的注解仅保存在class文件中，它们不会被加载进JVM；
    RUNTIME类型的注解会被加载进JVM，并且在运行期可以被程序读取。

 */