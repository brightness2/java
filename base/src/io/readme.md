# IO
IO是指Input/Output，即输入和输出。以内存为中心：

    Input指从外部读入数据到内存，例如，把文件从磁盘读取到内存，从网络读取数据到内存等等。

    Output指把数据从内存输出到外部，例如，把数据从内存写入到文件，把数据从内存输出到网络等等。

## InputStream / OutputStream

IO流以byte（字节）为最小单位，因此也称为字节流

在Java中，InputStream代表输入字节流，OuputStream代表输出字节流，这是最基本的两种IO流

## Reader / Writer
如果我们需要读写的是字符，并且字符不全是单字节表示的ASCII字符，那么，按照char来读写显然更方便，这种流称为字符流。

Java提供了Reader和Writer表示字符流，字符流传输的最小数据单位是char。

Reader和Writer本质上是一个能自动编解码的InputStream和OutputStream

## 同步和异步

同步IO是指，读写IO时代码必须等待数据返回后才继续执行后续代码，它的优点是代码编写简单，缺点是CPU执行效率低。

而异步IO是指，读写IO时仅发出请求，然后立刻执行后续代码，它的优点是CPU执行效率高，缺点是代码编写复杂。

Java标准库的包java.io提供了同步IO，而java.nio则是异步IO。上面我们讨论的InputStream、OutputStream、Reader和Writer都是同步IO的抽象类，对应的具体实现类，以文件为例，有FileInputStream、FileOutputStream、FileReader和FileWriter。

## 小结

IO流是一种流式的数据输入/输出模型：

    二进制数据以byte为最小单位在InputStream/OutputStream中单向流动；

    字符数据以char为最小单位在Reader/Writer中单向流动。

Java标准库的java.io包提供了同步IO功能：

    字节流接口：InputStream/OutputStream；

    字符流接口：Reader/Writer。



