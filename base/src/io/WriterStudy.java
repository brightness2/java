package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriterStudy {
    public void run() throws IOException {
        /*
        Reader是带编码转换器的InputStream，它把byte转换为char，而Writer就是带编码转换器的OutputStream，它把char转换为byte并输出。
                OutputStream	                        Writer
            字节流，以byte为单位	                    字符流，以char为单位
            写入字节（0~255）：void write(int b)	    写入字符（0~65535）：void write(int c)
            写入字节数组：void write(byte[] b)	    写入字符数组：void write(char[] c)
            无对应方法	                            写入String：void write(String s)
         */
        try(Writer writer = new FileWriter("./src/io/data/out.txt", StandardCharsets.UTF_8)){
            writer.write('H'); // 写入单个字符
            writer.write("Hello".toCharArray()); // 写入char[]
            writer.write("World"); // 写入String
        }

        /**使用OutputStreamWriter, OutputStream转换为Writer的转换器*/
        try(Writer writer = new OutputStreamWriter(new FileOutputStream("./src/io/data/out.txt"),StandardCharsets.UTF_8)){

        }
    }
}
/*
小结

Writer定义了所有字符输出流的超类：

    FileWriter实现了文件字符流输出；

    CharArrayWriter和StringWriter在内存中模拟一个字符流输出。

使用try (resource)保证Writer正确关闭。

Writer是基于OutputStream构造的，可以通过OutputStreamWriter将OutputStream转换为Writer，转换时需要指定编码。
 */
