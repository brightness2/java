# 引入第三方jar包

## idea 中引入
```
File -> Project Structure -> Module
点击加号->apply->ok
```

## 手动引入
```
1、下载后，解压，找到commons-logging-1.2.jar这个文件
2、再把Java源码Main.java放到一个目录下，例如work目录
work
│
├─ commons-logging-1.2.jar
│
└─ Main.java
3、然后用javac编译Main.java，编译的时候要指定classpath，不然编译器找不到我们引用的org.apache.commons.logging包。编译命令如下：

javac -cp commons-logging-1.2.jar Main.java

如果编译成功，那么当前目录下就会多出一个Main.class文件：
work
│
├─ commons-logging-1.2.jar
│
├─ Main.java
│
└─ Main.class
4、现在可以执行这个Main.class，使用java命令，也必须指定classpath，命令如下：

java -cp .;commons-logging-1.2.jar Main

```

## 最佳实践
在开发阶段，始终使用Commons Logging接口来写入日志，并且开发阶段无需引入Log4j。如果需要把日志写入文件， 只需要把正确的配置文件和Log4j相关的jar包放入classpath，就可以自动把日志切换成使用Log4j写入，无需修改任何代码。

## 最新日志组合推荐
SLF4J和Logback