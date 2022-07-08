package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesStudy {
    public void run() throws IOException {
        //从Java 7开始，提供了Files这个工具类，能极大地方便我们读写文件。

        //把一个文件的全部内容读取为一个byte[]
        byte[] data = Files.readAllBytes(Path.of("./src/io/data/test.txt"));
        /*
        如果是文本文件，可以把一个文件的全部内容读取为String：

// 默认使用UTF-8编码读取:
String content1 = Files.readString(Path.of("/path/to/file.txt"));
// 可指定编码:
String content2 = Files.readString(Path.of("/path", "to", "file.txt"), StandardCharsets.ISO_8859_1);
// 按行读取并返回每行内容:
List<String> lines = Files.readAllLines(Path.of("/path/to/file.txt"));

         */
        /*
        写入文件也非常方便：

// 写入二进制文件:
byte[] data = ...
Files.write(Path.of("/path/to/file.txt"), data);
// 写入文本并指定编码:
Files.writeString(Path.of("/path/to/file.txt"), "文本内容...", StandardCharsets.ISO_8859_1);
// 按行写入文本:
List<String> lines = ...
Files.write(Path.of("/path/to/file.txt"), lines);

         */
        //此外，Files工具类还有copy()、delete()、exists()、move()等快捷方法操作文件和目录。
        /**
         * 最后需要特别注意的是，Files提供的读写方法，受内存限制，只能读写小文件，例如配置文件等，不可一次读入几个G的大文件。读写大型文件仍然要使用文件流，每次只读写一部分文件内容。
         */
    }
}
