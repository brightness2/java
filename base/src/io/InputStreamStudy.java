package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamStudy{
    public void run() throws IOException {
//        InputStream input = null;
//        try {
//         input = new FileInputStream("./src/io/data/test.txt");
//
//            for (;;){
//                int n = input.read();//反复调用read()方法，直到返回-1,必须等待read()方法返回才能执行下一行代码
//                if(-1 == n){
//                    break;
//                }
//                System.out.println(n);//打印byte的值
//            }
//        }finally {
//           if(null != input){
//               input.close();//关闭流
//           }
//
//        }
        //上面代码复杂，可以使用 try(resource)的语法
         try (InputStream input = new FileInputStream("./src/io/data/test.txt")) {
                int n;
                while ((n = input.read()) != -1) {
                    System.out.println(n);
                }
         } // 编译器在此自动为我们写入finally并调用close()

        /****利用缓冲区读取多个字节******/
        try(InputStream input2 = new FileInputStream("./src/io/data/test.txt")){
            //定义1000个字节大小的缓冲区：
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input2.read(buffer)) != -1){
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
/*
小结

Java标准库的java.io.InputStream定义了所有输入流的超类：

    FileInputStream实现了文件流输入；

    ByteArrayInputStream在内存中模拟一个字节流输入。

总是使用try(resource)来保证InputStream正确关闭。

 */