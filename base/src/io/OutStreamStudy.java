package io;

import java.io.*;

public class OutStreamStudy {
    public void run() throws IOException {
//        OutputStream output = new FileOutputStream("./src/io/data/out.txt");
//        output.write(72);//H
//        output.write(101);//e
//        output.write(108);//l
//        output.write(108);//l
//        output.write(111);//o
//        output.close();

        //一次性写入若干字节
        try( OutputStream output = new FileOutputStream("./src/io/data/out.txt")){
            output.write("World".getBytes("UTF-8"));//会覆盖,方法也是阻塞的
        }

        //同时操作多个AutoCloseable资源时，在try(resource) { ... }语句中可以同时写出多个资源，用;隔开。例如，同时读写两个文件
        String inputFile = "./src/io/data/test.txt";
        String outputFile = "./src/io/data/out.txt";
        try(
                InputStream input1 = new FileInputStream(inputFile);
                OutputStream output1 = new FileOutputStream(outputFile)
                ){
            input1.transferTo(output1);//transferTo的作用是?
        }
    }
}
/*
小结

Java标准库的java.io.OutputStream定义了所有输出流的超类：

    FileOutputStream实现了文件流输出；

    ByteArrayOutputStream在内存中模拟一个字节流输出。

某些情况下需要手动调用OutputStream的flush()方法来强制输出缓冲区。

总是使用try(resource)来保证OutputStream正确关闭。
 */