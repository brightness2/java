package io;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathStudy {
    public void run() throws IOException {
        //在classpath中的资源文件，路径总是以／开头，我们先获取当前的Class对象，然后调用getResourceAsStream()就可以直接从classpath读取任意的资源文件：
        System.out.println(getClass().getResource(""));//F:/我的资料/java/base/out/production/base/io/
        System.out.println(getClass().getResource("/"));//F:/我的资料/java/base/out/production/base/
        System.out.println(getClass().getResource("."));//F:/我的资料/java/base/out/production/base/io/
        System.out.println(getClass().getResource("./data/test.txt"));//F:/我的资料/java/base/out/production/base/io/data/test.txt

        try (InputStream input = getClass().getResourceAsStream("./data/test.txt")) {
            if (input != null) {
                for (;;){
                    int n = input.read();
                    if(-1 == n){
                        break;
                    }
                    System.out.print((char) n);
                }
            }
        }


    }
}
/*
小结

把资源存储在classpath中可以避免文件路径依赖；

Class对象的getResourceAsStream()可以从classpath中读取指定资源；

根据classpath读取资源时，需要检查返回的InputStream是否为null。
 */