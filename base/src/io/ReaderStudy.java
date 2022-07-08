package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderStudy {
    public void run() throws IOException {
        /*
        Reader是Java的IO库提供的另一个输入流接口。和InputStream的区别是，InputStream是一个字节流，即以byte为单位读取，而Reader是一个字符流，即以char为单位读取
        InputStream	                            Reader
        字节流，以byte为单位	                字符流，以char为单位
        读取字节（-1，0~255）：int read()	    读取字符（-1，0~65535）：int read()
        读到字节数组：int read(byte[] b)	    读到字符数组：int read(char[] c)
         */
        try(Reader reader = new FileReader("./src/io/data/test.txt", StandardCharsets.UTF_8)){
            for (;;){
                int n = reader.read();
                if(-1 == n){
                    break;
                }
                System.out.print((char) n);
            }
        }

        /**char[]转reader
         * CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader
         */
        try (Reader reader = new CharArrayReader("Hello".toCharArray())) {
        }
        //StringReader可以直接把String作为数据源，它和CharArrayReader几乎一样：
        try (Reader reader = new StringReader("Hello")) {
        }
        /**使用InputStreamReader,InputStream转换为Reader*/
//        // 持有InputStream:
//        InputStream input = new FileInputStream("./src/io/data/test.txt");
//        // 变换为Reader:
//        Reader reader = new InputStreamReader(input, StandardCharsets.UTF_8);
        try(Reader reader = new InputStreamReader(new FileInputStream("./src/io/data/test.txt"),StandardCharsets.UTF_8)){
            //使用try (resource)结构时，当我们关闭Reader时，它会在内部自动调用InputStream的close()方法，所以，只需要关闭最外层的Reader对象即可。

        }

    }
}
/*
小结

Reader定义了所有字符输入流的超类：

    FileReader实现了文件字符流输入，使用时需要指定编码；
    CharArrayReader和StringReader可以在内存中模拟一个字符流输入。

Reader是基于InputStream构造的：可以通过InputStreamReader在指定编码的同时将任何InputStream转换为Reader。

总是使用try (resource)保证Reader正确关闭。
 */