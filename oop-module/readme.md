# 模块化

## 编译命令
```
javac -d bin src/module-info.java src/com/*.java
```

指定编译的class文件放到./bin文件夹,使用module-info.java 模块配置,指定源码文件 ./src/com/*.java

## 打包成jar
```
jar --create --file hello.jar --main-class com.Main -C bin . 
```

在打包的时候，注意传入--main-class参数，让这个jar包能自己定位main方法所在的类：

## 运行jar包

```
java -jar hello.jar
```

## 创建模块,继续使用JDK自带的jmod命令把一个jar包转换成模块

```
jmod create --class-path hello.jar hello.jmod
```

## 模块不可用java --module-path 运行

```
$ java --module-path hello.jmod --module hello.world

结果是一个错误：

Error occurred during initialization of boot layer
java.lang.module.FindException: JMOD format not supported at execution time: hello.jmod

原因是.jmod不能被放入--module-path中。换成.jar就没问题了：

$ java --module-path hello.jar --module hello.world
Hello, xml!

```

## 模块用来打包jre 

为了支持模块化，Java 9首先带头把自己的一个巨大无比的rt.jar拆成了几十个.jmod模块，原因就是，运行Java程序的时候，实际上我们用到的JDK模块，并没有那么多。不需要的模块，完全可以删除。

jlink 命令打包需要的模块

```
jlink --module-path hello.jmod --add-modules java.base,java.xml,hello.world --output jre/ 
```

在--module-path参数指定了我们自己的模块hello.jmod，然后，在--add-modules参数中指定了我们用到的2个模块java.base、java.xml和hello.world，用,分隔。最后，在--output参数指定输出目录。

现在，在当前目录下，我们可以找到jre目录，这是一个完整的并且带有我们自己hello.jmod模块的JRE。试试直接运行这个JRE：

```
jre/bin/java --module hello.world
```

要分发我们自己的Java应用程序，只需要把这个jre目录打个包给对方发过去，对方直接运行上述命令即可，既不用下载安装JDK，也不用知道如何配置我们自己的模块，极大地方便了分发和部署。

