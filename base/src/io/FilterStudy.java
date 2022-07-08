package io;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FilterStudy {
    public void run() throws IOException{
        /*
        Java的IO标准库提供的InputStream根据来源可以包括：

    FileInputStream：从文件读取数据，是最终数据源；
    ServletInputStream：从HTTP请求读取数据，是最终数据源；
    Socket.getInputStream()：从TCP连接读取数据，是最终数据源；
    ...
         */
        /*
        基于FileInputStream
        为缓冲功能，用BufferedInputStream包装这个InputStream
        为了直接读取解压缩的内容功能，再包装成GZIPInputStream
        ...
        ┌─────────────────────────┐
        │GZIPInputStream          │
        │┌───────────────────────┐│
        ││BufferedFileInputStream││
        ││┌─────────────────────┐││
        │││   FileInputStream   │││
        ││└─────────────────────┘││
        │└───────────────────────┘│
        └─────────────────────────┘
        如果有多个功能，继续包装下去，这样就会出现子类爆炸的情况。
        为了解决上述这种情况，通过一个“基础”组件再叠加各种“附加”功能组件的模式，称之为Filter模式（或者装饰器模式：Decorator）
                 ┌─────────────┐
                 │ InputStream │
                 └─────────────┘
                       ▲ ▲
┌────────────────────┐ │ │ ┌─────────────────┐
│  FileInputStream   │─┤ └─│FilterInputStream│
└────────────────────┘ │   └─────────────────┘
┌────────────────────┐ │     ▲ ┌───────────────────┐
│ByteArrayInputStream│─┤     ├─│BufferedInputStream│
└────────────────────┘ │     │ └───────────────────┘
┌────────────────────┐ │     │ ┌───────────────────┐
│ ServletInputStream │─┘     ├─│  DataInputStream  │
└────────────────────┘       │ └───────────────────┘
                             │ ┌───────────────────┐
                             └─│CheckedInputStream │
                               └───────────────────┘
         */

        byte[] data = "hello, world!".getBytes("UTF-8");
        try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
            System.out.println("Total read " + input.getBytesRead() + " bytes");
        }
    }
}

/**编写一个CountInputStream，它的作用是对输入的字节进行计数**/

class CountInputStream extends FilterInputStream{
    private int count = 0;

    CountInputStream(InputStream in){
        super(in);
    }

    public int getBytesRead(){
        return  this.count;
    }

    public int read() throws IOException{
        int n = in.read();
        if(-1 != n){
            this.count++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}
/*
小结

Java的IO标准库使用Filter模式为InputStream和OutputStream增加功能：

    可以把一个InputStream和任意个FilterInputStream组合；

    可以把一个OutputStream和任意个FilterOutputStream组合。

Filter模式可以在运行期动态增加功能（又称Decorator模式）。
 */